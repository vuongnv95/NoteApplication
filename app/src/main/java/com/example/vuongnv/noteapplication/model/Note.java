package com.example.vuongnv.noteapplication.model;

public class Note {
    private String mTitle;
    private String mSubject;
    private String mDate;
    private String mTime;

    public Note(String mTitle, String mSubject, String mDate, String mTime) {
        this.mTitle = mTitle;
        this.mSubject = mSubject;
        this.mDate = mDate;
        this.mTime = mTime;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String mSubject) {
        this.mSubject = mSubject;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
