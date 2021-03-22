package com.recommendationSystem.recommendationSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNeedsRepository extends JpaRepository<UserNeeds, String> {
    public void deleteByuserName(String userName);
}
