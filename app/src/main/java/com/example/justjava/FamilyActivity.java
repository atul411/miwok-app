package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer myMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Daughter", "hija", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Father", "padre", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Grand Father", "abuelo", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("Grand mother", "abuela", R.drawable.family_grandmother, R.raw.family_mother));
        words.add(new Word("Mother", "madre", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Older Brother", "hermano mayor", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("older sister", "hermana mayor", R.drawable.family_older_sister, R.raw.family_daughter));
        words.add(new Word("Son", "hijo", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Younger Brother", "hermano más joven", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Younger sister", "hermana menor", R.drawable.family_younger_sister, R.raw.family_younger_sister));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.family_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FamilyActivity.this,"List Item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                myMedia = MediaPlayer.create(FamilyActivity.this, word.AudioResourceId());
                myMedia.start();
                myMedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                        Toast.makeText(FamilyActivity.this, "completed", Toast.LENGTH_SHORT).show();
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