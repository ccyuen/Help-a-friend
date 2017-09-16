package com.example.staff.helpafriend;

public class User {
    private int ID;
    private String Name;
    private String UserName;
    private String Email;
    private int Points;
    /////////////////////////
    //constructor
    public User(int ID, String name, String userName, String email) {
        this.ID = ID;
        Name = name;
        UserName = userName;
        Email = email;
        Points=0;
    }
    ////////////////////////////
    //default constructor
    public User(){
        this.ID=0;
        this.Points=0;
        this.UserName="";
        this.Name="";
        this.Email="";
    }
    ////////////////////////////
    // getters
    public int getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public String getUserName() {
        return UserName;
    }
    public String getEmail() {
        return Email;
    }
    public int getPoints() {
        return Points;
    }
    ///////////////////////////////
    // setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setPoints(int points) {
        Points = points;
    }
    //////////////////////////////////////////
    public void addPoints(int points){
        this.Points+=points;
    }
    public void subPoints(int points){
        this.Points-=points;
    }
}
