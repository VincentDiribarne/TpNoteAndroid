package com.example.uno.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uno.Autres.Joueur;
import com.example.uno.R;

import java.util.List;

public class FinActivity extends AppCompatActivity {
    private List<Joueur> joueursList = CreationActivity.joueurList;
    private Button bouton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        bouton = findViewById(R.id.fin);

        //Retour à l'accueil
        //Pas de score, car l'appli ne fonctionne pas
        bouton.setOnClickListener(v -> startActivity(new Intent(this, AccueilActivity.class)));
    }
}
