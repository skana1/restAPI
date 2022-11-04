package com.api.app.rest.Controller;

import com.api.app.rest.Models.Login;
import com.api.app.rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody String userName, String password){
        userService.login( userName, password);
        return "LOGGED IN";
    }

}
