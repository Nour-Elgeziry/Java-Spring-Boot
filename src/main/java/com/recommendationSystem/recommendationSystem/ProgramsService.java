package com.recommendationSystem.recommendationSystem;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramsService {

    @Autowired
    private ProgramsRepository repo;

    public List<Programs> listAll() {
        return repo.findAll();
    }

    public void save(Programs content) {
        repo.save(content);
    }

    public Programs get(String name) {
        return repo.findById(name).get();
    }

    public void delete(String name) {
        repo.deleteByName(name); //name - primary key in the Programs table
    }   
    
}
