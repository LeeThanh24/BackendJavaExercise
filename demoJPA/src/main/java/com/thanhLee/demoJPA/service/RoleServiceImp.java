package com.thanhLee.demoJPA.service;

import com.thanhLee.demoJPA.dto.RoleDTO;
import com.thanhLee.demoJPA.entity.RolesEntity;
import com.thanhLee.demoJPA.repository.RoleRepository;
import com.thanhLee.demoJPA.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service

public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRoles ()
    {
        List<RolesEntity> rolesEntityList = roleRepository.findAll();
        List < RoleDTO> roleDTOList = new ArrayList<>();
        for (RolesEntity data : rolesEntityList
        ) {
            roleDTOList.add(new RoleDTO(data.getId(),data.getName(),data.getDescription()));
        }

        return roleDTOList ;
    }

    @Override
    public List<RoleDTO> getRolesByName(String name) {
        List<RolesEntity> rolesEntityList = roleRepository.findByName(name );
        List < RoleDTO> roleDTOList = new ArrayList<>();
        for (RolesEntity data : rolesEntityList
        ) {
            roleDTOList.add(new RoleDTO(data.getId(),data.getName(),data.getDescription()));
        }

        return roleDTOList ;
    }
}
