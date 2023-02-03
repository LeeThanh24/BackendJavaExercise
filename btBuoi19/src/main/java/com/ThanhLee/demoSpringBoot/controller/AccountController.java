package com.ThanhLee.demoSpringBoot.controller;

import com.ThanhLee.demoSpringBoot.model.AccountModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/{id}/{customerName}")
    public ResponseEntity<? > index (@PathVariable("id") int myId , @PathVariable("customerName") String cusName)
    {
        return new ResponseEntity<>("Hello restful api which id ="+ myId + " and customer name is " + cusName , HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> insertAccount (@PathVariable int id , @RequestBody AccountModel accountModel)
    {
//        AccountModel accountModel = new AccountModel();
        accountModel.setId(id);
//        accountModel.setCustomerName("Le dao xuan thanh");
//        accountModel.setAge(20);
        return new ResponseEntity<>(accountModel,HttpStatus.OK);
    }
}
