package com.shadhini.tryouts.java.oop.coupled_vs_decoupled_implementation.my_tube_decoupled;

public class VideoProcessor {
    // With this decoupled version of VideoProcessor we can implement unit testing for this component
    // without getting involved with real encode, database or notification service
    VideoEncoder encoder;
    VideoDatabase database;
    NotificationService notificationService;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, NotificationService notificationService) {
        this.encoder = encoder;
        this.database = database;
        this.notificationService = notificationService;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationService.sendEmail(video.getUser());

    }
}
