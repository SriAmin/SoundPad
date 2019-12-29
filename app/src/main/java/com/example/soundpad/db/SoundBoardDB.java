package com.example.soundpad.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.soundpad.Soundboard;

//Database for SoundBoards
@Database(entities = {Soundboard.class}, version = 2)
public abstract class SoundBoardDB extends RoomDatabase {
    public abstract SoundBoardDAO soundBoardDAO();
    private static volatile SoundBoardDB INSTANCE;

    //Used to obtain the sound board database inside its file
    static SoundBoardDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SoundBoardDB.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        SoundBoardDB.class, "soundBoard_database").addCallback(soundBoardDBCallback)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }

    //Used to populate database when app starts up
    private static SoundBoardDB.Callback soundBoardDBCallback = new SoundBoardDB.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final SoundBoardDAO sbDao;

        PopulateDbAsync(SoundBoardDB db) {
            sbDao = db.soundBoardDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            return null;
        }
    }
}
