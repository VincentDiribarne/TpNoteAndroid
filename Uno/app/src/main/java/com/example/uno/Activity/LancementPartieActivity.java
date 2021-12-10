package com.example.uno.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uno.Autres.Cartes;
import com.example.uno.Autres.Defausse;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.Autres.PaquetCartes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LancementPartieActivity extends AppCompatActivity {
    public static PaquetCartes paquetCartes = new PaquetCartes();
    public static Defausse defausse = new Defausse();
    public List<Cartes> mainJoueur = new ArrayList<>();
    private List<Joueur> joueursList = CreationActivity.joueurList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < joueursList.size(); i++) {
            mainJoueur.clear();
            for (int j = 0; j < 7; j++) {
                //Ajout des cartes dans la main du joueur
                mainJoueur.add(paquetCartes.getPaquetDeCartes().remove(NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size() - 1, 1)));
            }
            joueursList.get(i).setMainCartes(mainJoueur);
        }

        //Ajout de la defausse
        defausse.getDefausse().add(paquetCartes.getPaquetDeCartes().remove(NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size() - 1, 1)));
        startActivity(new Intent(this, JouerActivite.class));
    }
}
