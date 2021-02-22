
package com.example.justjava;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, Number.class);
                startActivity(numbersIntent);
            }
        });

        final TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FamilyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(FamilyIntent);
            }
        });
        String a = Integer.toString(12);
        System.out.println(a);
        final TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent = new Intent(MainActivity.this, Color.class);
                startActivity(colorIntent);
            }
        });

        final TextView phrase = (TextView) findViewById(R.id.phrases);
        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this, Phrase.class);
                startActivity(phrasesIntent);
            }
        });


    }

}







