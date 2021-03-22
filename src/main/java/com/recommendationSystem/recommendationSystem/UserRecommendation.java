package com.recommendationSystem.recommendationSystem;

import javax.persistence.*;

@Entity
@Table(name = "userrecommendation")
public class UserRecommendation {
  private int no;
  private String userName;
  private String recommendation;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "no")
  public int getId(){
    return no;
  }
  public void setId(int id){
    this.no = id;
  }

  @Column(name="username") //username - primary key in the Recommendation table
  public String getUserName() {
      return userName;
  }

  public void setUserName(String name) {
  this.userName = name;
  } 

  @Column(name="recommendation")
  public String getRecommendation() {
      return recommendation;
  }

  public void setRecommendation(String recommendedProgram) {
  this.recommendation = recommendedProgram;
  } 
    
}
