package com.shadhini.java.tryouts.tools.my_tube_improved;

public class Video {
    // Basically a data container
    // This doesn't have an implementation/algorithm
    // So this is less likely to change
    // Once we add the attributes and setters and getters, we are done with the class
    private String title;
    private String fileName;
    private User user;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
