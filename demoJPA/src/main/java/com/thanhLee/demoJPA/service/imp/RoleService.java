package com.thanhLee.demoJPA.service.imp;

import com.thanhLee.demoJPA.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRoles() ;
    List <RoleDTO>getRolesByName (String name ) ;
}
