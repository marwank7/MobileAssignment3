package com.example.mobileassignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.game_recycle);

        String[] captions = new String[Game.games.length];
        int[] ids = new int[Game.games.length];

        for(int i = 0 ; i < captions.length ; i++){
            captions[i] = Game.games[i].getName();
            ids[i] = Game.games[i].getImgID();
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter adapter = new ImageAdapter(MainActivity.this ,captions, ids);
        rv.setAdapter(adapter);
    }
}