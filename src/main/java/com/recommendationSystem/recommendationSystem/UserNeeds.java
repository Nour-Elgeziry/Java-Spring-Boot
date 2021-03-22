package com.recommendationSystem.recommendationSystem;

import javax.persistence.*;

@Entity
@Table(name = "userneeds")
public class UserNeeds {
  private int no;
  private String userName;
  private String need;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "no")
  public int getId(){
    return no;
  }
  public void setId(int id){
    this.no = id;
  }



  @Column(name="username") //username - primary key in the UserNeeds table
  public String getUserName() {
      return userName;
  }

  public void setUserName(String name) {
  this.userName = name;
  } 

  @Column(name="need")
  public String getNeed() {
      return need;
  }

  public void setNeed(String userNeed) {
  this.need = userNeed;
  } 
}
