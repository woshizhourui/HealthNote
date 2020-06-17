package com.example.healthnote.bean;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDataBase.class)
public class RecordsBean extends BaseModel {
    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private String year;
    @Column
    private String month;
    @Column
    private String day;
    @Column
    private String content;
    @Column
    private boolean isFinish;

    public void insertData(String year, String month, String day, String content) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.content = content;
    }

    public void insertResult(String year, String month, String day, String content, boolean isFinish) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.content = content;
        this.isFinish = isFinish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    @Override
    public String toString() {
        return "RecordsBean{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", content='" + content + '\'' +
                ", isFinish=" + isFinish +
                '}';
    }
}
