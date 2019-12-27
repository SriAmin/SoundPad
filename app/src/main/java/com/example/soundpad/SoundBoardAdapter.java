package com.example.soundpad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.soundpad.R;
import com.example.soundpad.Soundboard;

import java.util.ArrayList;

//Sets the view for each SoundBoard item within the List View
public class SoundBoardAdapter extends ArrayAdapter {

    private Context context;

    public SoundBoardAdapter(@NonNull Context context, ArrayList<Soundboard> soundboards) {
        super(context, 0, soundboards);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.soundboard_item, parent, false);
        }

        //Sets the position and elements of each list element
        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        TextView txtDate = convertView.findViewById(R.id.txtDate);
        TextView txtAuthor = convertView.findViewById(R.id.txtAuthor);
        ImageView imgView = convertView.findViewById(R.id.imageView);

        Soundboard soundboard = (Soundboard) getItem(position);

        txtTitle.setText(soundboard.getTitle());
        txtDate.setText(soundboard.getDate());
        txtAuthor.setText(soundboard.getAuthor());

        return convertView;
    }
}
