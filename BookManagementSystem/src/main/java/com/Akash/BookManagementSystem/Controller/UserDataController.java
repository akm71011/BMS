package com.Akash.BookManagementSystem.Controller;

import com.Akash.BookManagementSystem.Model.UserDataModel;
import com.Akash.BookManagementSystem.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/userData")
public class UserDataController {

    @Autowired
    UserDataRepository userDataRepository;

    Logger logger = Logger.getLogger(UserDataController.class.getName());

    @GetMapping(value = "/view/{userId}")
    public UserDataModel viewUser(@PathVariable("userId") Integer id){
        UserDataModel user = userDataRepository.getUser(id);
        if(user == null)
            return null;
       return user;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody UserDataModel user) {
        logger.info("Adding User");
        userDataRepository.addUser(user);
        return "User Added";
    }
}
