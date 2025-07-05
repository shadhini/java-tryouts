package com.shadhini.tryouts.java.oop.coupled_vs_decoupled_implementation.my_tube;

public class EmailService {
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
