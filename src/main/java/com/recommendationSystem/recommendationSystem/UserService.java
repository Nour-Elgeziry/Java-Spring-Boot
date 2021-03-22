package com.recommendationSystem.recommendationSystem;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return repo.findAll();
    }

    public void save(User content) {
        repo.save(content);
    }

    public User get(String name) {
        return repo.findById(name).get();
    }

    public void delete(String name) {
        repo.deleteByUserName(name); //username - primary key in the User table
    }   
    
}
