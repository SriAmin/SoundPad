package com.example.soundpad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Model of Sound Board inside the database
@Entity(tableName = "soundBoard_table")
public class Soundboard {

    @PrimaryKey
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "author")
    String author;

    @ColumnInfo(name = "sounds")
    String sounds;

    public Soundboard(int id, String title, String date, String author, String sounds) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.sounds = sounds;
    }

    //Getters and Setters for every member variables within the class
    public int getId() {return id;}

    public void setId (int id) {this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getAuthor () {return author;}

    public void setAuthor (String author) {this.author = author;}

    public String getSounds() {return sounds;}

    public void setSounds(String sounds) {this.sounds = sounds;}
}
