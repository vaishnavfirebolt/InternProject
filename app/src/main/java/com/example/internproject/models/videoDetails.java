package com.example.internproject.models;

public class videoDetails {
    private String videoName;
    private String videoID;

    public videoDetails(String videoName, String videoID) {
        this.videoName = videoName;
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoID() {
        return videoID;
    }
}
