package com.api.app.rest.Service;

import com.api.app.rest.Models.Login;
import com.api.app.rest.Models.User;
import com.api.app.rest.Models.UserRepository;
import com.api.app.rest.Repo.UserRepo;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepo userRepo;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, UserRepository userRepository){
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    public User save(User user){
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return this.userRepo.save(user);
    }

    public String login(Login login) throws Exception {
        String username = login.getUserName();
        User foundUser = this.userRepository.getUserByUserName(username);

        if(foundUser == null) {
            throw new Exception( "User with that username does not exist!");
        }

        if (passwordEncoder.matches(login.getPassword(), foundUser.getPassword()) == false){
            throw new Exception("Incorrect password");

        }else {
            System.out.println("Success");
        }

        //krahaso passw
        // System.out.println(foundUser);

        return "User found";
    }
}


