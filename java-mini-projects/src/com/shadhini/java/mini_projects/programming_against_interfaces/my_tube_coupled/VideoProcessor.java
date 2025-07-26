package com.shadhini.java.mini_projects.programming_against_interfaces.my_tube_coupled;

public class VideoProcessor {
    // Tightly coupled to classes Video, VideoEncoder, VideoDatabase, EmailService
    public void process(Video video) {
        var encoder = new VideoEncoder();
        encoder.encode(video);

        var database = new VideoDatabase();
        database.store(video);

        var emailService = new EmailService();
        emailService.sendEmail(video.getUser());

    }
}
