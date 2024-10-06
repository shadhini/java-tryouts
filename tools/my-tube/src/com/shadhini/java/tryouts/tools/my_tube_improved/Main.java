package com.shadhini.java.tryouts.tools.my_tube_improved;

public class Main {
    public static void main(String[] args) {
        var video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's Birthday");
        video.setUser(new User("john@domain.com"));

        var processor = new VideoProcessor(
                new DefaultVideoEncoder(),
                new DefaultVideoDatabase(),
                new DefaultEmailService()
        );
        processor.process(video);
    }
}
