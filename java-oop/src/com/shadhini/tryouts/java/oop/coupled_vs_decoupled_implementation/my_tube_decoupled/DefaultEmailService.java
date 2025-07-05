package com.shadhini.tryouts.java.oop.coupled_vs_decoupled_implementation.my_tube_decoupled;

public class DefaultEmailService implements NotificationService {
    @Override
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
