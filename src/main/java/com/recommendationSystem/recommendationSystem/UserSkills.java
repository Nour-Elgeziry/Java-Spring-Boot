package com.recommendationSystem.recommendationSystem;

import javax.persistence.*;

@Entity
@Table(name = "userskills")
public class UserSkills {
  private int no;
  private String userName;
  private String skill;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "no")
  public int getId(){
    return no;
  }
  public void setId(int id){
    this.no = id;
  }

  @Column(name="username") //username - primary key in the UserSkills table
  public String getUserName() {
      return userName;
  }

  public void setUserName(String name) {
  this.userName = name;
  } 

  @Column(name="skill")
  public String getSkill() {
      return skill;
  }

  public void setSkill(String userSkill) {
  this.skill = userSkill;
  } 
}
