package com.example.shootings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView blueball;
    private ImageView greenball;
    private ImageView redball;
    private ImageView yellowball;
    private ImageView enemy_ship;
    private ImageView ship;

    private float shipY;
    private float enemy_shipY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreLabel = findViewById(R.id.scoreLabel);
        startLabel = findViewById(R.id.startLabel);
        ship = findViewById(R.id.ship);
        enemy_ship = findViewById(R.id.enemy_ship);
        blueball = findViewById(R.id.blueball);
        greenball = findViewById(R.id.greenball);
        redball = findViewById(R.id.redball);
        yellowball = findViewById(R.id.yellowball);

        blueball.setX(-80.0f);
        blueball.setY(-80.0f);
        greenball.setX(-80.0f);
        greenball.setY(-80.0f);
        redball.setX(-80.0f);
        redball.setY(-80.0f);
        yellowball.setX(-80.0f);
        yellowball.setY(-80.0f);

        startLabel.setVisibility(View.INVISIBLE);
        shipY = 500.0f;

    }
}