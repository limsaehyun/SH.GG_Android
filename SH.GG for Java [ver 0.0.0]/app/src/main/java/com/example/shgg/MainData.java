package com.example.shgg;

public class MainData {
    private String tv_winLose;
    private String tv_redName;
    private String tv_blueName;

    public MainData(String tv_winLose, String tv_redName, String tv_blueName) {
        this.tv_winLose = tv_winLose;
        this.tv_redName = tv_redName;
        this.tv_blueName = tv_blueName;
    }

    public String getTv_winLose() {
        return tv_winLose;
    }

    public String getTv_redName() {
        return tv_redName;
    }

    public String getTv_blueName() {
        return tv_blueName;
    }
}
