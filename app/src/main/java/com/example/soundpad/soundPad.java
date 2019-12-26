package com.example.soundpad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class soundPad extends AppCompatActivity {

    TextView txtID;
    TextView txtTitle;
    TextView txtDate;
    TextView txtAuthor;
    TextView txtSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pad);
        this.referWidget();
        txtID.setText(getIntent().getStringExtra("ID"));
        txtTitle.setText(getIntent().getStringExtra("TITLE"));
        txtDate.setText(getIntent().getStringExtra("DATE"));
        txtAuthor.setText(getIntent().getStringExtra("AUTHOR"));
        txtSound.setText(getIntent().getStringExtra("SOUND"));
    }

    private void referWidget() {
        txtID = findViewById(R.id.txtID);
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtSound = findViewById(R.id.txtSound);
    }
}
