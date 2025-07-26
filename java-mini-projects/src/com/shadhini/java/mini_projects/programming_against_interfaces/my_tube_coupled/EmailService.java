package com.shadhini.java.mini_projects.programming_against_interfaces.my_tube_coupled;

public class EmailService {
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
