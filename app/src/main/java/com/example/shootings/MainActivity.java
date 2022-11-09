package com.example.shootings;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView blueball;
    private ImageView greenball;
    private ImageView redball;
    private ImageView yellowball;
    private ImageView enemy_ship;
    private ImageView ship;

    private int frameHeight;
    private int screenWidth;
    private int screenHeight;

    private float shipY;
    private float enemy_shipY;
    private float blueballX;
    private float blueballY;
    private float greenballX;
    private float greenballY;
    private float redballX;
    private float redballY;
    private float yellowballX;
    private float yellowballY;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

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

        // Screen Size
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;
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

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);
    }

    public void changePos() {

        // greenball
        greenballY += 20;
        if (greenballY > screenHeight) {
            greenballY = -80.0f;
            greenballX = (float)Math.floor(Math.random() * (screenWidth - greenball.getWidth()));
        }
        greenball.setX(greenballX);
        greenball.setY(greenballY);

        // redball
        redballY += 40;
        if (redballY > screenHeight) {
            redballY = -80.0f;
            redballX = (float)Math.floor(Math.random() * (screenWidth - redball.getWidth()));
        }
        redball.setX(redballX);
        redball.setY(redballY);

        // yellowball
        yellowballY += 30;
        if (yellowballY > screenHeight) {
            yellowballY = -80.0f;
            yellowballX = (float)Math.floor(Math.random() * (screenWidth - yellowball.getWidth()));
        }
        yellowball.setX(yellowballX);
        yellowball.setY(yellowballY);

    }

}