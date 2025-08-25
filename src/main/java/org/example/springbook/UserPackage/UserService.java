package org.example.springbook.UserPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public void addUser(User user){
        if(repository.findByUsername(user.getUsername()).isEmpty())
            repository.save(user);
        else throw new RuntimeException("User already exists");

    }
}
