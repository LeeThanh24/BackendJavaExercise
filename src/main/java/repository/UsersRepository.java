package repository;

import Model.UsersColumn;
import Model.UsersModel;
import config.MysqlConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    public int countUserByEmailAndPassword (String email ,String password) {
        int count = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "select count(*) as count from users  u where u.email = ? and password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            //System.out.println(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count ;
    }

    public List<UsersModel> printUsers () {
        Connection connection = MysqlConfig.getConnection();
        String query = "select * from users";
        List<UsersModel> finalList = new ArrayList<>();
        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String email = resultSet.getString(UsersColumn.EMAIL.getValue());
                finalList.add(new UsersModel( email ));
            }
        }catch (SQLException e)
        {
            System.out.println("Error in sql statment :" +e.getMessage());
        }finally
        {
            if (connection != null )
            {
                try
                {
                    connection.close();
                }catch (Exception e )
                {
                    System.out.println("Error connection in closing : "+e.getMessage());
                }
            }
        }
        return finalList;
    }
}

