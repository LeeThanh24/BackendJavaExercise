package com.thanhLee.demoJPA.service;

import com.thanhLee.demoJPA.dto.UserDTO;
import com.thanhLee.demoJPA.entity.UsersEntity;
import com.thanhLee.demoJPA.repository.UserRepository;
import com.thanhLee.demoJPA.service.imp.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDTO> getUserByEmailAndPassword(String email, String password)
    {
        List < UsersEntity> usersEntityList = userRepository.findByEmailAndPassword(email,password);
        List <UserDTO> userDTOList = new ArrayList<>() ;
        for (UsersEntity data   : usersEntityList
             ) {
            userDTOList.add(new UserDTO(data.getId(),data.getEmail(),data.getPassword(),data.getFullname(),data.getAvatar()));
        }

        return userDTOList ;

    }

    public UsersEntity saveToDatabase(UsersEntity usersEntity)
    {
        return userRepository.save(usersEntity);
    }
}
