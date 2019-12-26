package com.example.soundpad;

import android.content.Intent;
import android.os.Bundle;

import com.example.soundpad.viewModel.SoundBoardViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    ListView lstSoundBoard;
    ArrayAdapter soundBoardAdatper;
    ArrayList<Soundboard> soundboardArrayList;
    private SoundBoardViewModel soundBoardViewModel;
    private static final int NEW_SOUND_BOARD_REQUEST_CODE = 1;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        soundboardArrayList = new ArrayList<Soundboard>();

        lstSoundBoard = findViewById(R.id.lstSoundBoard);

        //soundBoardViewModel = new SoundBoardViewModel(getApplication());

        this.populateList();

//        soundBoardViewModel.getAllFruits().observe(this, new Observer<List<Soundboard>>() {
//            @Override
//            public void onChanged(List<Soundboard> soundboards) {
//                soundboardArrayList.clear();
//                for (Soundboard soundboard : soundboards) {
//                    soundboardArrayList.add(soundboard);
//                }
//            }
//        });

        soundBoardAdatper = new SoundBoardAdapter(MainActivity.this, soundboardArrayList);
        lstSoundBoard.setAdapter(soundBoardAdatper);

        this.listViewListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void populateList() {

        soundboardArrayList.add(new Soundboard(1, "Test", simpleDateFormat.format(new Date()), "Sri Amin", "Sound 1"));
        soundboardArrayList.add(new Soundboard(2, "Jah", simpleDateFormat.format(new Date()), "XXXTentacion", "Sound 2"));
        soundboardArrayList.add(new Soundboard(3, "Juice", simpleDateFormat.format(new Date()), "Juice Wrld", "Sound 3"));
        soundboardArrayList.add(new Soundboard(4, "John", simpleDateFormat.format(new Date()), "Johhny Sins", "Sound 4"));
        soundboardArrayList.add(new Soundboard(5, "Man", simpleDateFormat.format(new Date()), "Mandingo", "Sound 5"));
        Log.d("MainActivity.class", "Array Listed Populated");
    }

    private void listViewListener() {
        lstSoundBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Soundboard soundboard = soundboardArrayList.get(position);
                Intent soundPadIntent = new Intent(MainActivity.this, soundPad.class);
                soundPadIntent.putExtra("ID", Integer.toString(soundboard.getId()));
                soundPadIntent.putExtra("TITLE", soundboard.getTitle());
                soundPadIntent.putExtra("DATE", soundboard.getDate());
                soundPadIntent.putExtra("AUTHOR", soundboard.getAuthor());
                soundPadIntent.putExtra("SOUND", soundboard.getSounds());
                startActivity(soundPadIntent);
            }
        });
    }
}
