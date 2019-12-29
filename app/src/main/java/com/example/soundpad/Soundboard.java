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

    @ColumnInfo(name = "image")
    public
    Integer imgSoundPad;

    @ColumnInfo(name = "sound1")
    String sound1;

    @ColumnInfo(name = "sound2")
    String sound2;

    @ColumnInfo(name = "sound3")
    String sound3;

    @ColumnInfo(name = "sound4")
    String sound4;

    @ColumnInfo(name = "sound5")
    String sound5;

    @ColumnInfo(name = "sound6")
    String sound6;

    public Soundboard(int id, String title, String date, String author, Integer imgSoundPad, String sound1, String sound2, String sound3, String sound4, String sound5, String sound6) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.imgSoundPad = imgSoundPad;
        this.sound1 = sound1;
        this.sound2 = sound2;
        this.sound3 = sound3;
        this.sound4 = sound4;
        this.sound5 = sound5;
        this.sound6 = sound6;
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

    public Integer getImage() { return imgSoundPad; }

    public void setImage(Integer imgSoundPad) { this.imgSoundPad = imgSoundPad; }

    public String getSound1() {return sound1;}

    public void setSound1(String sound1) {this.sound1 = sound1;}

    public String getSound2() {return sound2;}

    public void setSound2(String sound1) {this.sound2 = sound2;}

    public String getSound3() {return sound3;}

    public void setSound3(String sound1) {this.sound3 = sound3;}

    public String getSound4() {return sound4;}

    public void setSound4(String sound1) {this.sound4 = sound4;}

    public String getSound5() {return sound5;}

    public void setSound5(String sound1) {this.sound5 = sound5;}

    public String getSound6() {return sound6;}

    public void setSound6(String sound1) {this.sound6 = sound6;}
}
