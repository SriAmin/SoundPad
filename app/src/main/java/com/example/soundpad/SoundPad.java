package com.example.soundpad;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoundPad extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5, mediaPlayer6;

    TextView txtID, txtTitle, txtDate, txtAuthor;
    Button btnSound1, btnSound2, btnSound3, btnSound4, btnSound5, btnSound6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pad);
        this.referWidget();

        //Will display sound board information
        txtID.setText(getIntent().getStringExtra("ID"));
        txtTitle.setText(getIntent().getStringExtra("TITLE"));
        txtDate.setText(getIntent().getStringExtra("DATE"));
        txtAuthor.setText(getIntent().getStringExtra("AUTHOR"));

        this.mediaPlaySetUp();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSound1:
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.seekTo(0);
                }
                else {
                    mediaPlayer1.start();
                }
                break;

            case R.id.btnSound2:
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.seekTo(0);
                }
                else {
                    mediaPlayer2.start();
                }
                break;

            case R.id.btnSound3:
                if (mediaPlayer3.isPlaying()) {
                    mediaPlayer3.seekTo(0);
                }
                else {
                    mediaPlayer3.start();
                }
                break;

            case R.id.btnSound4:
                if (mediaPlayer4.isPlaying()) {
                    mediaPlayer4.seekTo(0);
                }
                else {
                    mediaPlayer4.start();
                }
                break;

            case R.id.btnSound5:
                if (mediaPlayer5.isPlaying()) {
                    mediaPlayer5.seekTo(0);
                }
                else {
                    mediaPlayer5.start();
                }
                break;

            case R.id.btnSound6:
                if (mediaPlayer6.isPlaying()) {
                    mediaPlayer6.seekTo(0);
                }
                else {
                    mediaPlayer6.start();
                }
                break;
        }
    }

    //Assigns elements on XML files to this file to interact with
    private void referWidget() {
        txtID = findViewById(R.id.txtID);
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtAuthor = findViewById(R.id.txtAuthor);

        //Assigns the multiple buttons for each sound
        btnSound1 = findViewById(R.id.btnSound1);
        btnSound1.setOnClickListener(this);
        btnSound2 = findViewById(R.id.btnSound2);
        btnSound2.setOnClickListener(this);
        btnSound3 = findViewById(R.id.btnSound3);
        btnSound3.setOnClickListener(this);
        btnSound4 = findViewById(R.id.btnSound4);
        btnSound4.setOnClickListener(this);
        btnSound5 = findViewById(R.id.btnSound5);
        btnSound5.setOnClickListener(this);
        btnSound6 = findViewById(R.id.btnSound6);
        btnSound6.setOnClickListener(this);
    }

    //Settings up the media players for each sound so that they aren't assigned every time when button is pressed
    private void mediaPlaySetUp() {
        Uri audioURI1 = Uri.parse(getIntent().getStringExtra("SOUND1"));
        mediaPlayer1 = MediaPlayer.create(getApplicationContext(), audioURI1);

        Uri audioURI2 = Uri.parse(getIntent().getStringExtra("SOUND2"));
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), audioURI2);

        Uri audioURI3 = Uri.parse(getIntent().getStringExtra("SOUND3"));
        mediaPlayer3 = MediaPlayer.create(getApplicationContext(), audioURI3);

        Uri audioURI4 = Uri.parse(getIntent().getStringExtra("SOUND4"));
        mediaPlayer4 = MediaPlayer.create(getApplicationContext(), audioURI4);

        Uri audioURI5 = Uri.parse(getIntent().getStringExtra("SOUND5"));
        mediaPlayer5 = MediaPlayer.create(getApplicationContext(), audioURI5);

        Uri audioURI6 = Uri.parse(getIntent().getStringExtra("SOUND6"));
        mediaPlayer6 = MediaPlayer.create(getApplicationContext(), audioURI6);
    }
}
