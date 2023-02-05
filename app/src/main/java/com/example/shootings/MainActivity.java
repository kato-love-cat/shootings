package com.example.shootings;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
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
    private ImageView purpleball;
    private ImageView enemy_ship;
    private ImageView ship;

    private int frameHeight;
    private int framewidth;
    private int screenWidth;
    private int screenHeight;
    private int shipSize;

    private float shipX;
    private float shipY;
    private float enemy_shipX;
    private float enemy_shipY;
    private float blueballX;
    private float blueballY;
    private float greenballX;
    private float greenballY;
    private float redballX;
    private float redballY;
    private float yellowballX;
    private float yellowballY;
    private float purpleballX;
    private float purpleballY;
    //private int shipWidth;
    private int shipHeight;
    private int enemy_shipHeight;
    private int scoreLabelHeight;
    private int score = 0;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    private boolean action_flg = false;
    private boolean start_flg = false;

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
        purpleball = findViewById(R.id.purpleball);

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
        purpleball.setX(-80.0f);
        purpleball.setY(-80.0f);

        scoreLabel.setText("Score : 0 ");

    }

    public void changePos() {

        hitCheck();

        // ship
        if (action_flg) {
            shipX -= 20;

        } else {
            shipX += 20;
        }

        if (shipX < 0) shipX = 0;

        if (shipX > framewidth - shipSize) shipX = framewidth - shipSize;

        ship.setX(shipX);


        // blueball（自機）
        blueballY -= 30;
        if (blueballY < 0) {
            blueballY = screenHeight - ship.getHeight();
            blueballX = shipX;
        }
        blueball.setX(blueballX);
        blueball.setY(blueballY);

        // greenball（敵機）
        greenballY += 10;
        if (greenballY > screenHeight) {
            greenballY = 0 - 20;
            greenballX = (float)Math.floor(Math.random() * (screenWidth - greenball.getWidth()));
        }
        greenball.setX(greenballX);
        greenball.setY(greenballY);

        // redball（敵機）
        redballY += 12;
        if (redballY > screenHeight) {
            redballY = -80.0f;
            redballX = (float)Math.floor(Math.random() * (screenWidth - redball.getWidth()));
        }
        redball.setX(redballX);
        redball.setY(redballY);

        // yellowball（敵機）
        yellowballY += 14;
        if (yellowballY > screenHeight) {
            yellowballY = -80.0f;
            yellowballX = (float)Math.floor(Math.random() * (screenWidth - yellowball.getWidth()));
        }
        yellowball.setX(yellowballX);
        yellowball.setY(yellowballY);

        // purpleball（敵機）
        purpleballY += 16;
        if (purpleballY > screenHeight) {
            purpleballY = -80.0f;
            purpleballX = (float)Math.floor(Math.random() * (screenWidth - purpleball.getWidth()));
        }
        purpleball.setX(purpleballX);
        purpleball.setY(purpleballY);

        scoreLabel.setText("Score : " + score);

    }

    public void hitCheck() {

        shipHeight = ship.getHeight();
        enemy_shipHeight = enemy_ship.getHeight();
        scoreLabelHeight = scoreLabel.getHeight();

        // blueball（自機）
        float blueballCenterX = blueballX + blueball.getWidth() / 2;
        float blueballCenterY = blueballY + blueball.getHeight() / 2;

        if ( enemy_shipHeight - 10<= blueballCenterY && blueballCenterY <= enemy_shipHeight ) {

            //blueballY += enemy_shipHeight - shipHeight;
            score += 30;
        }

        // greenball（敵機）
        float greenballCenterX = greenballX + greenball.getWidth() / 2;
        float greenballCenterY = greenballY + greenball.getHeight() / 2;

        if ( screenHeight - shipHeight <= greenballCenterY && greenballCenterY <= screenHeight &&
            shipX <= greenballCenterX && greenballCenterX <= shipX +shipSize) {

            greenballX -= 1000;
            score -= 5;
        }

        // redball（敵機）
        float redballCenterX = redballX + redball.getWidth() / 2;
        float redballCenterY = redballY + redball.getHeight() / 2;

        if ( screenHeight - shipHeight <= redballCenterY && redballCenterY <= screenHeight &&
                shipX <= redballCenterX && redballCenterX <= shipX +shipSize) {

            redballX -= 1000;
            score -= 10;
        }

        // yellowball（敵機）
        float yellowballCenterX = yellowballX + yellowball.getWidth() / 2;
        float yellowballCenterY = yellowballY + yellowball.getHeight() / 2;

        if ( screenHeight - shipHeight <= yellowballCenterY && yellowballCenterY <= screenHeight &&
                shipX <= yellowballCenterX && yellowballCenterX <= shipX +shipSize) {

            yellowballX -= 1000;
            score -= 15;
        }

        // purpleball（敵機）
        float purpleballCenterX = purpleballX + purpleball.getWidth() / 2;
        float purpleballCenterY = purpleballY + purpleball.getHeight() / 2;

        if ( screenHeight - shipHeight <= purpleballCenterY && purpleballCenterY <= screenHeight &&
                shipX <= purpleballCenterX && purpleballCenterX <= shipX +shipSize) {

            purpleballX -= 1000;
            score -= 20;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (start_flg == false) {

            start_flg = true;

            FrameLayout frame = findViewById(R.id.frame);
            framewidth = frame.getWidth();

            shipX = ship.getX();
            shipSize = ship.getWidth();




            startLabel.setVisibility(View.GONE);

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

        } else {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;

            }
        }
        return true;
    }
}