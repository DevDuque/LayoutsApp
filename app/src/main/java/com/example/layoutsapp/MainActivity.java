package com.example.layoutsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.layoutsapp.Screens.FormScreen;
import com.example.layoutsapp.Screens.NewsScreen;
import com.example.layoutsapp.Screens.ForecastScreen;

public class MainActivity extends AppCompatActivity {

    // Botões das telas
    private Button btnNews;
    private Button btnForecast;
    private Button btnForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializando os botões
        btnNews = findViewById(R.id.btn_news);
        btnForecast = findViewById(R.id.btn_forecast);
        btnForm = findViewById(R.id.btn_form);

        // Métodos de redirecionamento dos botões
        btnNews.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewsScreen.class);

            startActivity(intent);
        });

        btnForecast.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForecastScreen.class);

            startActivity(intent);
        });

        btnForm.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormScreen.class);

            startActivity(intent);
        });


    }
}