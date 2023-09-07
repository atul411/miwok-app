package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phrase extends AppCompatActivity {
    private MediaPlayer myMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Good morning.", "Buenos días.", -1, R.raw.phrase_are_you_coming));
        words.add(new Word("Good afternoon.", "Buenas tardes.", -1, R.raw.phrase_come_here));
        words.add(new Word("My name is Atul Yadav.", "Me llamo Atul Yadav.", -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word(" I'm pleased to meet you.", " Encantado de conocerte. ", -1, R.raw.phrase_im_coming));
        words.add(new Word("How are you?", "¿Cómo estás?",-1, R.raw.phrase_im_feeling_good));
        words.add(new Word("Where are you?", "¿Dónde estás?",-1, R.raw.phrase_lets_go));
        words.add(new Word("I'd like a beer.", " Me gustaría una cerveza.", -1, R.raw.phrase_my_name_is));
        words.add(new Word("I'm sorry.", "Lo siento.",-1, R.raw.phrase_what_is_your_name));
        words.add(new Word("See you soon!", "¡Hasta pronto!",-1, R.raw.phrase_where_are_you_going));
        words.add(new Word("Goodbye.", "Adiós.",-1, R.raw.phrase_yes_im_coming));
        words.add(new Word("Goodbye.", "Adiós.",-1, R.raw.phrase_yes_im_coming));
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.phrases);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Phrase.this,"List Item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                myMedia = MediaPlayer.create(Phrase.this, word.AudioResourceId());
                myMedia.start();

                myMedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                        Toast.makeText(Phrase.this, "completed", Toast.LENGTH_SHORT).show();
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