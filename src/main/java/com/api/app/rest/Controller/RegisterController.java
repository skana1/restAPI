package com.api.app.rest.Controller;

import com.api.app.rest.Models.Login;
import com.api.app.rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody Login login){
        userService.login(login);
        return "LOGGED IN";
    }

}
