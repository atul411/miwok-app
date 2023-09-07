package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Number extends AppCompatActivity {
    private MediaPlayer myMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number4);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "una", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "dos", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tres", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "cuatro", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "cinco", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "seis", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "siete", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "ocho", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "nueve", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "diez", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.number_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Number.this,"List Item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                myMedia = MediaPlayer.create(Number.this, word.AudioResourceId());
                myMedia.start();
                

                myMedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                        Toast.makeText(Number.this, "completed", Toast.LENGTH_SHORT).show();
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

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (myMedia != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            myMedia.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            myMedia = null;
        }
    }

}