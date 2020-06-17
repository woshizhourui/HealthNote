package com.example.healthnote.bean;

public class TxtAndChooseBean {
    private String title;
    private int status;
    private boolean isChoose;

    public TxtAndChooseBean(String title, boolean isChoose) {
        this.title = title;
        this.isChoose = isChoose;
    }

    public TxtAndChooseBean(String title, int status) {
        this.title = title;
        this.status = status;
    }

    public TxtAndChooseBean() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    @Override
    public String toString() {
        return "TxtAndChooseBean{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", isChoose=" + isChoose +
                '}';
    }
}
