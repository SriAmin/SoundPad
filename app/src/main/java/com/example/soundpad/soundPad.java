package com.example.soundpad;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class soundPad extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;

    TextView txtID;
    TextView txtTitle;
    TextView txtDate;
    TextView txtAuthor;
    TextView txtSound;
    Button btnPlay;

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
        txtSound.setText(getIntent().getStringExtra("SOUND"));

        //Creates and sets up the sound board
        Uri audioURI = Uri.parse(getIntent().getStringExtra("SOUND"));

        mediaPlayer = MediaPlayer.create(getApplicationContext(), audioURI);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                }
                else {
                    mediaPlayer.start();
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
        txtSound = findViewById(R.id.txtSound);
        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);
    }
}
