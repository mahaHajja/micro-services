package com.sth.users.Controllers;


import com.sth.commonmodels.Models.User;
import com.sth.users.reporitories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("")
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return usersRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        usersRepository.deleteById(id);
        return "deleted";
    }

    @PostMapping("/add")
    public String saveUser(@RequestBody User user) {
        usersRepository.save(user);
        return user.getName()+" is added";
    }
}