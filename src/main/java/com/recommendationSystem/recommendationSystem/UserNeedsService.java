package com.recommendationSystem.recommendationSystem;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserNeedsService {

    @Autowired
    private UserNeedsRepository repo;

    public List<UserNeeds> listAll() {
        return repo.findAll();
    }

    public void save(UserNeeds content) {
        repo.save(content);
    }

    public UserNeeds get(String name) {
        return repo.findById(name).get();
    }
  
    public void deleteAll(String name) {
        repo.deleteByuserName(name); //username - primary key in the Needs table
    } 
    
}