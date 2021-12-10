package com.example.uno.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Autres.AdaptateurMainJoueur;
import com.example.uno.Autres.Cartes;
import com.example.uno.Autres.Defausse;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.Autres.PaquetCartes;
import com.example.uno.R;

import java.util.Collections;
import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private Defausse defausse = LancementPartieActivity.defausse;
    private PaquetCartes paquetCartes = LancementPartieActivity.paquetCartes;
    private List<Cartes> mainJoueur;
    private List<Joueur> joueursList = CreationActivity.joueurList;

    private TextView pseudoJoueur;
    private Button findetour;
    private ImageView pioche, defausseImageView, invisible;
    private RecyclerView recyclerView;
    private AdaptateurMainJoueur adaptateurMainJoueur;

    public int i = 0;
    public boolean passage = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        invisible = findViewById(R.id.imageView);

        recyclerView = findViewById(R.id.recyclerViewCartes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        mainJoueur = joueursList.get(i).getMainCartes();
        adaptateurMainJoueur = new AdaptateurMainJoueur(mainJoueur);
        recyclerView.setAdapter(adaptateurMainJoueur);

        lancementTour();
    }



    //Change de joueur et fait toute les actions necessaires pour pouvoir jouer
    private void changementDeJoueur() {
        invisible.setVisibility(View.INVISIBLE);
        pseudoJoueur = findViewById(R.id.Pseudo);
        findetour = findViewById(R.id.finDeTour);
        pioche = findViewById(R.id.pioche);
        defausseImageView = findViewById(R.id.defausse);

        affichageTexte(i);
        defausseImageView.setBackgroundResource(defausse.getDefausse().get(defausse.getDefausse().size() - 1).getBackgroundCarte());

        plus_deux();
        change_sens();
        sens_interdit();

        pioche.setBackgroundResource(R.drawable.choix_couleur);

        this.adaptateurMainJoueur.notifyItemRemoved(getMainJoueur().size());

        findetour.setOnClickListener(v -> findetour());
        pioche.setOnClickListener(v -> pioche());
    }

    //Pour le sens interdit
    private void sens_interdit() {
        if(passage == false) {
            if (defausse.getDefausse().get(defausse.getDefausse().size() - 1).getNumero() == "PasseTour") {
                passage = true;
                i++;
                findetour();
            }
        }
    }

    //Pour le plus deux
    private void plus_deux() {
        if (defausse.getDefausse().get(defausse.getDefausse().size() - 1).getNumero() == "+2") {
            mainJoueur.add(paquetCartes.getPaquetDeCartes().remove((NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1))));
            mainJoueur.add(paquetCartes.getPaquetDeCartes().remove((NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1))));
            this.adaptateurMainJoueur.notifyItemInserted(mainJoueur.size() - 1);
        }
    }

    //Pour le changement de sens
    private void change_sens() {
        if (defausse.getDefausse().get(defausse.getDefausse().size() - 1).getNumero() == "ChangeSens") {
            Collections.reverse(joueursList);
        }
    }

    //Permet de piocher
    public void pioche() {
        mainJoueur.add(paquetCartes.getPaquetDeCartes().remove((NombreAleatoire.getNombreRandom(paquetCartes.getPaquetDeCartes().size(), 1))));
        if (paquetCartes.getPaquetDeCartes().size() < 10) {
            paquetCartes.getPaquetDeCartes().addAll(defausse.getDefausse());
        }
        adaptateurMainJoueur.notifyItemInserted(mainJoueur.size());
        findetour();
    }

    //Victoire
    private void victoire() {
        if (this.getMainJoueur().size() == 0) {
            startActivity(new Intent(this, FinActivity.class));
        }
    }

    //Fin de tour pour changer de joueur
    private void findetour() {
        victoire();
        i++;
        if (i >= joueursList.size()) {
            i = 0;
        }
        lancementTour();
    }

    //Affiche le joueur actuel
    private void affichageTexte(int i) {
        pseudoJoueur.setText(joueursList.get(i).getNom());
    }

    //Lance le tour
    public void lancementTour() {
        invisible.setVisibility(View.VISIBLE);
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.get(i).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.commencer, (dialog, which) -> {
                    changementDeJoueur();
                })
                .show();
    }

    //Getter et setter
    public List<Cartes> getMainJoueur() {
        return mainJoueur;
    }

    public void setMainJoueur(List<Cartes> mainJoueur) {
        this.mainJoueur = mainJoueur;
    }

    public void setDefausse(Defausse defausse) {
        this.defausse = defausse;
    }
}
