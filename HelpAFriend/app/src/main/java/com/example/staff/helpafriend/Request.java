package com.example.staff.helpafriend;

public class Request {
    private int ID;
    private String Location;
    private String Description;
    private User Helper;
    private User Reciever;
    private enum Status{
        Open, Closed, InProgress;
    }
    private Status status;
    //////////////////////////////
    //constructors
    public Request(int ID, String location, String description, Status status, User reciever) {
        this.ID = ID;
        Location = location;
        Description = description;
        this.status = status;
        Reciever = reciever;
    }
    public Request() {
        this.ID = 0;
        Location = "";
        Description = "";
        Helper = new User();
        this.status = Status.Open;
        Reciever = new User();
    }
    ////////////////////////////////
    // setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public void setHelper(com.example.staff.helpafriend.User user) {
        Helper = user;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setReciever(User reciever) {
        Reciever = reciever;
    }
    ////////////////////////////////////
    //getters
    public int getID() {
        return ID;
    }
    public String getLocation() {
        return Location;
    }
    public String getDescription() {
        return Description;
    }
    public com.example.staff.helpafriend.User getHelper() {
        return Helper;
    }
    public User getReciever() {
        return Reciever;
    }
    public Status getStatus() {
        return status;
    }
    public void RequestTaken(User helper){
        status =  Status.InProgress;
        Helper = helper;
    }
    public void RequestDone(){
        this.status = Status.Closed;
        Helper.addPoints(10);
    }
    public void RequestCancelled() {
        if (this.status == Status.InProgress) {
            Reciever.subPoints(5);
        } else{}
    }
}

