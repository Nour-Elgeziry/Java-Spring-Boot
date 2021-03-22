package com.recommendationSystem.recommendationSystem;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name="username")
    private String userName; 

    @Column(name = "email")
    private String email; 

    @Column(name = "skill1")
    private String skill1;
    @Column(name = "skill2")
    private String skill2;
    @Column(name = "skill3")
    private String skill3;
  
  
    @Column(name = "need")
    private String need;

    public String getUserName(){
        return userName;
    } 
    public void setUserName(String name){
        this.userName = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String userEmail){
        this.email = userEmail;
    }

    public String getSkill1(){
        return skill1;
    }
    public void setSkill1(String skill){
        this.skill1 = skill;
    }

    public String getSkill2(){
        return skill2;
    }
    public void setSkill2(String skill){
        this.skill2 = skill;
    }

    public String getSkill3(){
        return skill3;
    }
    public void setSkill3(String skill){
        this.skill3 = skill;
    }

    public String getNeed(){
        return this.need;
    }
    public void setNeed(String theNeed){
        this.need = theNeed;
    }

    //seting the user skills by composition
    public UserSkills addUserSkills1(){
            UserSkills userSkillsObj1 = new UserSkills();
            userSkillsObj1.setUserName(this.userName);
            userSkillsObj1.setSkill(this.skill1);
            
            return userSkillsObj1;
    }

    //seting the user skills by composition
    public UserSkills addUserSkills2(){
        UserSkills userSkillsObj2 = new UserSkills();
        userSkillsObj2.setUserName(this.userName);
        userSkillsObj2.setSkill(this.skill2);
        
        return userSkillsObj2;
    }

    //seting the user skills by composition
    public UserSkills addUserSkills3(){
        UserSkills userSkillsObj3 = new UserSkills();
        userSkillsObj3.setUserName(this.userName);
        userSkillsObj3.setSkill(this.skill3);
        
        return userSkillsObj3;
    }


    //setting the user needs by composition
    public UserNeeds addUserNeeds(){
        UserNeeds userNeedsObj = new UserNeeds();
        userNeedsObj.setUserName(this.userName);
        userNeedsObj.setNeed(this.need);
        return userNeedsObj;
    }

    //setting the user recommendations by composition
    public UserRecommendation addUserRecommendation(String program){
        UserRecommendation userRecommendationObj = new UserRecommendation();
        userRecommendationObj.setUserName(this.userName);
        userRecommendationObj.setRecommendation(program);
        return userRecommendationObj;
    }

}
