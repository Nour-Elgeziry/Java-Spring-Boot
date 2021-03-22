package com.recommendationSystem.recommendationSystem;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserSkillsService {

    @Autowired
    private UserSkillsRepository repo;

    public List<UserSkills> listAll() {
        return repo.findAll();
    }

    public void save(UserSkills content) {
        repo.save(content);
    }

    public UserSkills get(String name) {
        return repo.findById(name).get();
    }

       
    public void deleteAll(String name) {
        repo.deleteByuserName(name); 
    }
}
