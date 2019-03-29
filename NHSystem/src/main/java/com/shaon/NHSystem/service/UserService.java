package com.shaon.NHSystem.service;


import com.shaon.NHSystem.model.Role;
import com.shaon.NHSystem.model.User;
import com.shaon.NHSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role>roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }


    public void createAdmin(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role>roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findOneByEamil(String email){
        return userRepository.findOneByEmail(email);
    }

    public boolean isUserpresent(String email) {
        User u=userRepository.findOneByEmail(email);
        if (u!=null)
            return true;
        return false;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLike("%"+name+"%");
    }
}
