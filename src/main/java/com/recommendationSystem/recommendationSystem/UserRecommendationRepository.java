package com.recommendationSystem.recommendationSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecommendationRepository extends JpaRepository<UserRecommendation, String> {
    public List<UserRecommendation> findAllByuserName(String userName);
    public void deleteByuserName(String userName);
}
