package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
        MainActivity.mediaPlayer = MediaPlayer.create(this, R.raw.music);
        if(MainActivity.mediaPlayer != null){
            MainActivity.mediaPlayer.setLooping(true);
            MainActivity.mediaPlayer.start();
        }

        Button changeActivityBTN = findViewById(R.id.button);
        Button changeActivityBTN2 = findViewById(R.id.button2);

        changeActivityBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity();
            }
        });

        changeActivityBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private void changeActivity() {
        Intent intent = new Intent(this, newActivity.class);
        startActivity(intent);
        finish();

    }
}