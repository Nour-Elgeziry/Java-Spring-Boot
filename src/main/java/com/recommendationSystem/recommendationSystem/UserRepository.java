package com.recommendationSystem.recommendationSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public void deleteByUserName(String username);  //username - primary key in the User table
}
