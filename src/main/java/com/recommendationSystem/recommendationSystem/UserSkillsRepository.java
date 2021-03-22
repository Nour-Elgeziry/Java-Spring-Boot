package com.recommendationSystem.recommendationSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillsRepository extends JpaRepository<UserSkills, String> {
    public void deleteByuserName(String userName);
}
