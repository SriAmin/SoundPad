package com.example.soundpad.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.soundpad.Soundboard;
import com.example.soundpad.db.SoundBoardRepository;

import java.util.List;

//ViewModel for Sound Boards inside the Sound Board database
public class SoundBoardViewModel extends AndroidViewModel {
    private SoundBoardRepository soundBoardRepository;
    private LiveData<List<Soundboard>> allSoundBoards;

    //Used for inserting, deleted and obtaining all soundboards inside its database
    public SoundBoardViewModel(@NonNull Application application) {
        super(application);
        soundBoardRepository = new SoundBoardRepository(application);
        allSoundBoards = soundBoardRepository.getAllSoundBoards();
    }

    public LiveData<List<Soundboard>> getAllFruits() { return allSoundBoards; }

    public void insert(Soundboard soundboard) { soundBoardRepository.insert(soundboard); }

    public void delete(Soundboard soundboard) { soundBoardRepository.delete(soundboard); }
}
