package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Color extends AppCompatActivity {
    private MediaPlayer myMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Black", "negra", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Brown", "marrón", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Dusty Yellow", "Amarilla polvorienta", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Gray", "gris", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Green", "verde", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Mustard Yellow", "Amarillo mostaza", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("Red", "Rojo", R.drawable.color_red, R.raw.color_black));
        words.add(new Word("White", "blanca", R.drawable.color_white, R.raw.color_white));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.colors);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Color.this,"List Item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                releaseMediaPlayer();

                    myMedia = MediaPlayer.create(Color.this, word.AudioResourceId());
                    myMedia.start();

                    myMedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                            Toast.makeText(Color.this, "completed", Toast.LENGTH_SHORT).show();
                        }
                    });

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (myMedia != null) {
            myMedia.release();

            myMedia = null;
        }
    }
}