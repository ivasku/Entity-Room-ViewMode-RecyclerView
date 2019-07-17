package com.levi.architectureexampletms;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String desciption;

    @ColumnInfo(name = "priority")
    private int priority;

    public Note(String title, String desciption, int priority) {
        this.title = title;
        this.desciption = desciption;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesciption() {
        return desciption;
    }

    public int getPriority() {
        return priority;
    }
}
