package com.example.soundpad.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.soundpad.Soundboard;

import java.util.List;

@Dao
public interface SoundBoardDAO {
    @Insert
    void insert(Soundboard soundBoard);

    @Delete
    void delete(Soundboard soundboard);

    @Query("SELECT * FROM soundBoard_table ORDER BY id ASC")
    LiveData<List<Soundboard>> getAllSoundBoards();
}
