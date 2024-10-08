package com.example.layoutsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    // Duração da SplashScreen (1,5 segundo)
    private static final int SPLASH_DISPLAY_LENGTH = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Encontra a raiz da SplashScreen
        View splashScreen = findViewById(R.id.splash_screen);

        // Começa uma animação de fade-out depois de SPLASH_DISPLAY_LENGTH
        new Handler().postDelayed(() -> {
            Animation fadeOut = new AlphaAnimation(1, 0);

            // Duração do fade-out (1 segundo)
            fadeOut.setDuration(500);
            fadeOut.setFillAfter(true);
            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    // Começa a MainActivity
                    Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                    // Override the transition animation
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
            splashScreen.startAnimation(fadeOut);
        }, SPLASH_DISPLAY_LENGTH);
    }
}
