package repository;

import Model.RolesColumn;
import Model.RolesModel;
import config.MysqlConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public List<RolesModel> countAllRoles() {
        Connection connection = MysqlConfig.getConnection();
        String query = "select * from roles";
        List<RolesModel> finalList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(RolesColumn.ID.getValue());
                String name = resultSet.getString(RolesColumn.NAME.getValue());
                String description = resultSet.getString(RolesColumn.DESCRIPTION.getValue());
                finalList.add(new RolesModel(id, name, description));
            }
        } catch (SQLException e) {
            System.out.println("Error in sql statment :" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error connection in closing : " + e.getMessage());
                }
            }
        }
        return finalList;
    }


    public int deleteRoleById(int id) {
        int isSuccess = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "delete from roles r where r.id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , id );
            isSuccess= statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error deleting role by id : " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error in closing connection : " + e.getMessage());
            }
        }
        return isSuccess;
    }

    public int addNewRole (String name ,String desc)
    {
        int isSuccess = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "insert into  roles( name, description ) values (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1 , name );
            statement.setString(2 , desc );
            System.out.println(name);
            System.out.println(desc);
            System.out.println("set ok ");
            isSuccess= statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error adding role : " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error in closing connection : " + e.getMessage());
            }
        }
        return isSuccess;
    }
}
