package com.example.application.splashscreendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    private int SPLASH_SCREEN_TIME = 3; // Splash screen time in seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use this option to hide the title and notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        // We created a class (below) called LogoLauncher. Here, we need to create an instance of it
        //  in order to run it
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();

    }

    private class LogoLauncher extends Thread {
        // Wait 3 seconds, then call MainActivity and end SplashScreenActivity
        public void run() {
            try {
                sleep(1000 * SPLASH_SCREEN_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            SplashScreenActivity.this.finish();

        }
    }
}
