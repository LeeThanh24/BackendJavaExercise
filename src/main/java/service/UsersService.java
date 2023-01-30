package service;

import Model.UsersModel;
import repository.UsersRepository;

import java.util.List;

public class UsersService {
    public static  List<UsersModel> printAllUsers(){
        return (new UsersRepository().printUsers());
    }
}
