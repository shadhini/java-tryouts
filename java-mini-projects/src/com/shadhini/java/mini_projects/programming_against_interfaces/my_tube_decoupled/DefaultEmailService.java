package com.shadhini.java.mini_projects.programming_against_interfaces.my_tube_decoupled;

public class DefaultEmailService implements NotificationService {
    @Override
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
