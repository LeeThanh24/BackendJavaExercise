package com.thanhLee.demoJPA.controller;

import com.thanhLee.demoJPA.dto.RoleDTO;
import com.thanhLee.demoJPA.entity.RolesEntity;
import com.thanhLee.demoJPA.repository.RoleRepository;
import com.thanhLee.demoJPA.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;


    @GetMapping ("")
    public  ResponseEntity<?> getAllRoles ()
    {

        return new ResponseEntity<>(roleService.getAllRoles(),HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName (@PathVariable("name") String  name )
    {
        return new ResponseEntity<>(roleService.getRolesByName(name),HttpStatus.OK);
    }

}
