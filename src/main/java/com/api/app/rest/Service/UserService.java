package com.api.app.rest.Service;

import com.api.app.rest.Models.Login;
import com.api.app.rest.Models.User;
import com.api.app.rest.Models.UserRepository;
import com.api.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    UserRepository userRepository;
    UserRepo userRepo;
    PasswordEncoder passwordEncoder;

    List<String> userNames;
    List<User> users;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
        userNames = userRepository.getUserNames();
        users = userRepo.findAll();
    }

    public User save(User user){
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return this.userRepo.save(user);
    }


    public void login(String userName, String password) {

    }
}
