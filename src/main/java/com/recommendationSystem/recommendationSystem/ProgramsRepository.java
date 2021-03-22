package com.recommendationSystem.recommendationSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramsRepository extends JpaRepository<Programs, String> {
    public void deleteByName(String name);  //name - primary key in the Programs table
}

