package com.example.layoutsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.layoutsapp.Utils.Place;
import com.example.layoutsapp.Utils.PlaceAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPlaces;

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

        listViewPlaces = findViewById(R.id.list_view_places);

        // Criando uma lista de exemplos
        List<Place> places = new ArrayList<>();
        places.add(new Place("Parque da Cidade", R.drawable.parque, 0.5, 4.5));
        places.add(new Place("Praça Central", R.drawable.praca, 1.2, 4.0));
        places.add(new Place("Museu Histórico", R.drawable.museu, 2.3, 4.7));
        places.add(new Place("Teatro Municipal", R.drawable.teatro, 1.8, 4.2));

        PlaceAdapter adapter = new PlaceAdapter(this, places);
        listViewPlaces.setAdapter(adapter);


    }
}