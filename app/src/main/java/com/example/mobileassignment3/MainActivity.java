package com.example.mobileassignment3;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public  static  ArrayList<Game> games;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.game_recycle);
        games = new ArrayList<>();
        FitchJson fitchJson = new FitchJson();
        fitchJson.execute();
        String[] captions = new String[games.size()];
        int[] ids = new int[games.size()];
        for(int i = 0 ; i < games.size(); i++){
            captions[i] = (games.get(i)).getName();
            ids[i] = Integer.parseInt((games.get(i)).getImgID());
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter adapter = new ImageAdapter(MainActivity.this ,captions, ids);
        rv.setAdapter(adapter);
    }


    public  class FitchJson extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainFile="";
        @Override
        protected String doInBackground(String... strings) {
            URL url;
            try {
                url = new URL("http://10.0.2.2:8080/game.php");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line ="";
                while ((line=bufferedReader.readLine())!=null){
                    stringBuffer.append(line);
                }

                mainFile =stringBuffer.toString();
                JSONArray jsonArray = new JSONArray(mainFile);
                for (int i =0 ;i<jsonArray.length();i++){
                    JSONObject jsonObject  = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String genre = jsonObject.getString("genre");
                    String year = jsonObject.getString("year");
                    String developer = jsonObject.getString("developer");
                    String img_id = jsonObject.getString("img_id");
                    String lon = jsonObject.getString("lon");
                    String lat = jsonObject.getString("lat");
                    System.out.println(name);
                    games .add(new Game(name,genre,year,developer,img_id,lon,lat));

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


}