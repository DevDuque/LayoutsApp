package com.example.layoutsapp.Utils;


import android.widget.ImageButton;

import com.example.layoutsapp.R;

public class InputSelectionHelper {

    // Método para lidar com o clique em estrelas de avaliação
    public static int onStarClick(ImageButton clickedStar, ImageButton[] stars) {
        int selectedStar = -1;

        // Determina qual estrela foi clicada
        for (int i = 0; i < stars.length; i++) {
            if (stars[i].equals(clickedStar)) {
                // A estrela selecionada é o índice + 1 (1 a 5)
                selectedStar = i + 1;

                // Define as estrelas como ativas ou inativas com base no índice
                setStarActive(clickedStar, stars, i);
                break;
            }
        }

        return selectedStar;
    }

    // Método privado para configurar as estrelas como ativas ou inativas
    private static void setStarActive(ImageButton clickedStar, ImageButton[] stars, int position) {
        // Define as estrelas como ativas ou inativas com base no índice do clique
        for (int i = 0; i <= position; i++) {
            stars[i].setImageResource(R.drawable.img_staractive);
        }

        for (int i = position + 1; i < stars.length; i++) {
            stars[i].setImageResource(R.drawable.img_starinactive);
        }
    }
}
