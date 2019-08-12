package com.example.myergedd.bean;

public class MusicBean {

    private String title;
    private String path;
    private long duration;

    public MusicBean(String title, String path, long duration) {
        this.title = title;
        this.path = path;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "MusicBean{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", duration=" + duration +
                '}';
    }
}
