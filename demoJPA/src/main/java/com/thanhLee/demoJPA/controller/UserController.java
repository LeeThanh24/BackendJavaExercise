package com.thanhLee.demoJPA.controller;

import com.thanhLee.demoJPA.dto.UserDTO;
import com.thanhLee.demoJPA.entity.RolesEntity;
import com.thanhLee.demoJPA.entity.UsersEntity;
import com.thanhLee.demoJPA.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("")
    public ResponseEntity<?> getUserByEmailAndPassword (@RequestBody UserDTO userDTO)
    {
        return new ResponseEntity<>(userService.getUserByEmailAndPassword(userDTO.getEmail(),userDTO.getPassword()), HttpStatus.OK);
    }

    @GetMapping ("/add")
    public ResponseEntity<?> addUser (@RequestBody UsersEntity usersEntity)
    {

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(2);
        rolesEntity.setName("test");
        rolesEntity.setDescription("test desc");
        usersEntity.setRoles(rolesEntity);

        userService.saveToDatabase(usersEntity);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
