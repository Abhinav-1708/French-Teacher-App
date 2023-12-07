package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button black, yellow, red, purple, green;

    @Override
    public void onClick(View v) {
        // Find the button by ID and play the correct sound
        int clickedBtnID = v.getId();
        if (clickedBtnID == R.id.red) {
            playSounds(R.raw.red);
        } else if (clickedBtnID == R.id.black) {
            playSounds(R.raw.black);
        } else if (clickedBtnID == R.id.yellow) {
            playSounds(R.raw.yellow);
        } else if (clickedBtnID == R.id.purple) {
            playSounds(R.raw.purple);
        } else if (clickedBtnID == R.id.green) {
            playSounds(R.raw.green);
        }
    }

    public void playSounds(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Release the MediaPlayer resources
                mp.release();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        black = findViewById(R.id.black);
        yellow = findViewById(R.id.yellow);
        red = findViewById(R.id.red);
        purple = findViewById(R.id.purple);
        green = findViewById(R.id.green);

        red.setOnClickListener(this);
        black.setOnClickListener(this);
        yellow.setOnClickListener(this);
        green.setOnClickListener(this);
        purple.setOnClickListener(this);
    }
}
