package com.api.app.rest.Service;

import com.api.app.rest.Models.Login;
import com.api.app.rest.Models.User;
import com.api.app.rest.Repo.UserRepo;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepo userRepo;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user){
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return this.userRepo.save(user);
    }

    public void login(Login login) {
    }
}
