package com.recommendationSystem.recommendationSystem;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserRecommendationService {

    @Autowired
    private UserRecommendationRepository repo;

    public List<UserRecommendation> listAll() {
        return repo.findAll();
    }

    

    public void save(UserRecommendation content) {
        repo.save(content);
    }

    public UserRecommendation get(String name) {
        return repo.findById(name).get();
    }

    

    public List<String> findRecommendedPrograms(String name){
        List<String>recommendedProgramNames = new ArrayList<String>(); ;
        System.out.println(repo.findAllByuserName(name));
        //loop through recommendations and get recommendation name
        for(UserRecommendation reco: repo.findAllByuserName(name)){
            recommendedProgramNames.add(reco.getRecommendation());
        }
        System.out.println("User Recommended Program names are");
        System.out.println(recommendedProgramNames);
        return recommendedProgramNames;
    }

    
    public void deleteAll(String name) {
        repo.deleteByuserName(name); 
    }



     
    
}
