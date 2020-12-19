package com.example.mobileassignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        String[] captions = new String[Game.games.length];
        int[] ids = new int[Game.games.length];

        for(int i = 0 ; i < captions.length ; i++){
            captions[i] = Game.games[i].getName();
            ids[i] = Game.games[i].getImgID();
        }

        ImageView imageView = findViewById(R.id.image);
        TextView title = findViewById(R.id.title);
        TextView year = findViewById(R.id.year);
        TextView developer = findViewById(R.id.developer);
        TextView genre = findViewById(R.id.genre);
        Integer id =Integer.valueOf(getIntent().getStringExtra("ID"));
        title.setText("Title: " +Game.games[id].getName());
        year.setText("Year: " +Game.games[id].getYear());
        genre.setText("Genre: " +Game.games[id].getGenre());
        developer.setText("By: " +Game.games[id].getDeveloper());
        Drawable dr = ContextCompat.getDrawable(this, Game.games[id].getImgID());
        imageView.setImageDrawable(dr);



    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}