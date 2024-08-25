package com.example.layoutsapp.Screens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.layoutsapp.R;
import com.example.layoutsapp.Utils.InputSelectionHelper;

public class FormScreen extends AppCompatActivity {

    // Botão de Voltar
    private ImageButton btnBack;

    // Botões das Estrelas
    private ImageButton[] stars = new ImageButton[5];

    // Botão de confirmar
    private Button btnForm;

    // Campos do Formulário
    private EditText inputEmail, inputName, inputComment;

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

        // Inicializando os campos & botões
        inputEmail = findViewById(R.id.input_email);
        inputName = findViewById(R.id.input_name);
        inputComment = findViewById(R.id.input_comment);

        btnForm = findViewById(R.id.btn_form);
        btnBack = findViewById(R.id.btn_back);

        // Inicializa os botões das estrelas
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

        // Configura listeners para clique de voltar
        btnBack.setOnClickListener(v -> {
            // Finalizando Activity e Voltando para Home
            finish();
        });

        // Configura listeners para clique de confirmar o formulário
        btnForm.setOnClickListener(v -> {
            // Construindo o AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(FormScreen.this);
            builder.setTitle("Confirmação");
            builder.setMessage("Tem certeza que deseja enviar o comentário?");

            // Botão de confirmação
            builder.setPositiveButton("Confirmar", (dialog, which) -> {
                // Exibe uma mensagem de confirmação com Toast
                Toast.makeText(FormScreen.this, "Comentário enviado com sucesso!", Toast.LENGTH_SHORT).show();

                // Reseta o formulário
                resetForm();
            });

            // Botão de cancelamento
            builder.setNegativeButton("Cancelar", (dialog, which) -> {
                // Exibe uma mensagem de cancelamento com Toast
                Toast.makeText(FormScreen.this, "Envio do comentário cancelado.", Toast.LENGTH_SHORT).show();
            });

            // Criando e exibindo o AlertDialog
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    private void resetForm() {
        // Limpando os campos
        inputEmail.setText("");
        inputName.setText("");
        inputComment.setText("");

        selectedStar = 0;
        InputSelectionHelper.resetStarSelection(stars);
    }
}