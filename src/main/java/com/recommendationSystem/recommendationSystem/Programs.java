package com.recommendationSystem.recommendationSystem;

import javax.persistence.*;

@Entity
@Table(name = "programs")
public class Programs {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "requiredskill")
    private String requiredSkill;

    @Column(name = "requiredneed")
    private String requiredNeed;

    public String getProgram() {
        return this.name;
    }
    public void setProgram(String programName) {
        this.name = programName;
    }

    public String getRequiredSkill() {
        return this.requiredSkill;
    }
    public void setRequiredSkill(String skill){
        this.requiredSkill = skill;
    }

    public String getRequiredNeed() {
        return this.requiredNeed;
    }
    public void setRequiredNeed(String need){
        this.requiredNeed = need;
    }

}
