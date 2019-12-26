package com.example.soundpad.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.soundpad.Soundboard;

import java.util.List;

public class SoundBoardRepository {
    private SoundBoardDAO soundBoardDAO;
    private LiveData<List<Soundboard>> allSoundBoards;

    public SoundBoardRepository(Application application) {
        SoundBoardDB db = SoundBoardDB.getDatabase(application);
        soundBoardDAO = db.soundBoardDAO();
        allSoundBoards = soundBoardDAO.getAllSoundBoards();
    }

    public LiveData<List<Soundboard>> getAllSoundBoards() { return allSoundBoards; }

    public void insert (Soundboard soundboard) { new insertAsyncTask(soundBoardDAO).execute(soundboard); }

    public void delete (Soundboard soundboard) { new deleteAsyncTask(soundBoardDAO).execute(soundboard); }

    public static class insertAsyncTask extends AsyncTask<Soundboard, Void, Void> {
        private SoundBoardDAO asyncTaskDao;
        public insertAsyncTask(SoundBoardDAO soundBoardDAO) { asyncTaskDao = soundBoardDAO; }

        @Override
        protected Void doInBackground(Soundboard... soundboards) {
            asyncTaskDao.insert(soundboards[0]);
            return null;
        }
    }

    public static class deleteAsyncTask extends AsyncTask<Soundboard, Void, Void> {
        private SoundBoardDAO asyncTaskDao;
        public deleteAsyncTask(SoundBoardDAO soundBoardDAO) { asyncTaskDao = soundBoardDAO; }

        @Override
        protected Void doInBackground(Soundboard... soundboards) {
            asyncTaskDao.delete(soundboards[0]);
            return null;
        }
    }
}
