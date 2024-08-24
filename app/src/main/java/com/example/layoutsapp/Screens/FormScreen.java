package com.example.layoutsapp.Screens;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.layoutsapp.R;
import com.example.layoutsapp.Utils.InputSelectionHelper;

public class FormScreen extends AppCompatActivity {

    // Botão de Voltar
    private ImageButton btnBack;

    private ImageButton[] stars = new ImageButton[5];

    private int selectedStar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa os botões
        stars[0] = findViewById(R.id.star1);
        stars[1] = findViewById(R.id.star2);
        stars[2] = findViewById(R.id.star3);
        stars[3] = findViewById(R.id.star4);
        stars[4] = findViewById(R.id.star5);

        // Configura listeners para cliques nas estrelas para selecionar a avaliação
        for (ImageButton star : stars) {
            star.setOnClickListener(v -> {
                // Chama o helper para selecionar a estrela
                selectedStar = InputSelectionHelper.onStarClick((ImageButton) v, stars);
            });
        }

        // Inicializando & Criando Regra de Clique
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            // Finalizando Activity e Voltando para Home
            finish();
        });
    }
}