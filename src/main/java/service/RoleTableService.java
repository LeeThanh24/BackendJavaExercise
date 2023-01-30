package service;

import Model.RolesModel;
import repository.RoleRepository;

import java.util.List;

public class RoleTableService {
    public static  List <RolesModel> printAllRoles()
    {
        RoleRepository roleRepository = new RoleRepository();
        return roleRepository.countAllRoles();
    }

    public boolean deleteRoleById (int id )
    {
        RoleRepository rs = new RoleRepository();
        return rs .deleteRoleById(id) >=1 ;
    }

    public boolean addNewRole (String name ,String desc )
    {
        RoleRepository roleRepository = new RoleRepository();
        return roleRepository.addNewRole(name,desc ) >=1 ;
    }
}
