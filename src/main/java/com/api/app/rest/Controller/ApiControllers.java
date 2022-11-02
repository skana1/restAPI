package com.api.app.rest.Controller;
import com.api.app.rest.Models.User;
import com.api.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved";
    }
    @PutMapping (value = "/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        updatedUser.setUserName(user.getUserName());
        updatedUser.setPassword(user.getPassword());
        userRepo.save(updatedUser);
        return "updated";
    }
    @DeleteMapping (value = "/delete/{id}")
    public String deleteUser (@ PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with id" + id;
    }
}
