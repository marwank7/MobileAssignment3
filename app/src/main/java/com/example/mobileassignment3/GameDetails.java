package com.example.mobileassignment3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class GameDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Geocoder geocoder;
        geocoder = new Geocoder(this, Locale.getDefault());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        String[] captions = new String[MainActivity.games.size()];
        int[] ids = new int[MainActivity.games.size()];

        for(int i = 0 ; i < captions.length ; i++){
            captions[i] = (MainActivity.games.get(i)).getName();
            ids[i] = (MainActivity.games.get(i)).getImgID();
        }

        ImageView imageView = findViewById(R.id.image);
        TextView title = findViewById(R.id.title);
        TextView year = findViewById(R.id.year);
        TextView developer = findViewById(R.id.developer);
        TextView genre = findViewById(R.id.genre);
        TextView location = findViewById(R.id.location);
        Integer id =Integer.valueOf(getIntent().getStringExtra("ID"));
        title.setText("Title: " +(MainActivity.games.get(id)).getName());
        year.setText("Year: " +(MainActivity.games.get(id)).getYear());
        genre.setText("Genre: " +(MainActivity.games.get(id)).getGenre());
        developer.setText("By: " +(MainActivity.games.get(id)).getDeveloper());
        try {
            location.setText("Location: "+ geocoder.getFromLocation(MainActivity.games.get(id).getLon(), MainActivity.games.get(id).getLat(), 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable dr = ContextCompat.getDrawable(this, (MainActivity.games.get(id)).getImgID());
        imageView.setImageDrawable(dr);



    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}