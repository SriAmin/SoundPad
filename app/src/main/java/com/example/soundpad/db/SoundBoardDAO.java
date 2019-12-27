package com.example.soundpad.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.soundpad.Soundboard;

import java.util.List;

//DAO for SoundBoard for sound board database
@Dao
public interface SoundBoardDAO {

    //Functions used for inserting, deleting and obtaining all sound boards for the database
    @Insert
    void insert(Soundboard soundBoard);

    @Delete
    void delete(Soundboard soundboard);

    @Query("SELECT * FROM soundBoard_table ORDER BY id ASC")
    LiveData<List<Soundboard>> getAllSoundBoards();
}
