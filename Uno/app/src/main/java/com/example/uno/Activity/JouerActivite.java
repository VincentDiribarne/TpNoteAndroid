package com.example.uno.Activity;

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
import com.example.uno.Autres.Couleur;
import com.example.uno.Autres.Joueur;
import com.example.uno.Autres.NombreAleatoire;
import com.example.uno.R;

import java.util.ArrayList;
import java.util.List;

public class JouerActivite extends AppCompatActivity {
    private List<Cartes> paquetCartes = new ArrayList<>();
    private List<Cartes> defausse = new ArrayList<>();
    private List<Cartes> mainJoueur = new ArrayList<>();

    private TextView pseudoJoueur;
    private Button findetour;
    private ImageView pioche, defausseImageView;
    private RecyclerView recyclerView;
    private AdaptateurMainJoueur adaptateurMainJoueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);
        pseudoJoueur = findViewById(R.id.Pseudo);
        findetour = findViewById(R.id.finDeTour);
        pioche = findViewById(R.id.pioche);
        defausseImageView = findViewById(R.id.defausse);

        Intent intentRecup = getIntent();

        int intentNombre = intentRecup.getIntExtra("Position", -1);
        List<Joueur> joueursList = CreationActivity.joueurs;
        findetour.setVisibility(View.INVISIBLE);
        recyclerView = findViewById(R.id.recyclerViewCartes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if (intentNombre == -1) {
            initList();
            for (int i = 0; i < joueursList.size(); i++) {
                for (int j = 0; j < 7; j++) {
                    mainJoueur.add(paquetCartes.remove(NombreAleatoire.getNombreRandom(paquetCartes.size(), 1)));
                }
                joueursList.get(i).setMainCartes(mainJoueur);
                Log.i("Joueur", joueursList.get(i).getNom());
                Log.i("Main Joueur", String.valueOf(joueursList.get(i).getMainCartes()));
            }
            intentNombre = 0;
            lancementTour(joueursList, intentNombre);
        } else {
            affichageTexte(joueursList, intentNombre);
            affichageCarte(joueursList, intentNombre);

            pioche.setOnClickListener(v -> {
                mainJoueur.add(paquetCartes.remove(NombreAleatoire.getNombreRandom(paquetCartes.size(), 1)));
                findetour.setVisibility(View.VISIBLE);
            });

            int finalIntentNombre = intentNombre;
            findetour.setOnClickListener(v -> lancementTour(joueursList, finalIntentNombre));
        }
    }

    private void initList() {
        paquetCartes.add(new Cartes("0", Couleur.Bleu));
        paquetCartes.add(new Cartes("1", Couleur.Bleu));
        paquetCartes.add(new Cartes("2", Couleur.Bleu));
        paquetCartes.add(new Cartes("3", Couleur.Bleu));
        paquetCartes.add(new Cartes("4", Couleur.Bleu));
        paquetCartes.add(new Cartes("5", Couleur.Bleu));
        paquetCartes.add(new Cartes("6", Couleur.Bleu));
        paquetCartes.add(new Cartes("7", Couleur.Bleu));
        paquetCartes.add(new Cartes("8", Couleur.Bleu));
        paquetCartes.add(new Cartes("9", Couleur.Bleu));
        paquetCartes.add(new Cartes("1", Couleur.Bleu));
        paquetCartes.add(new Cartes("2", Couleur.Bleu));
        paquetCartes.add(new Cartes("3", Couleur.Bleu));
        paquetCartes.add(new Cartes("4", Couleur.Bleu));
        paquetCartes.add(new Cartes("5", Couleur.Bleu));
        paquetCartes.add(new Cartes("6", Couleur.Bleu));
        paquetCartes.add(new Cartes("7", Couleur.Bleu));
        paquetCartes.add(new Cartes("8", Couleur.Bleu));
        paquetCartes.add(new Cartes("9", Couleur.Bleu));
        paquetCartes.add(new Cartes("+2", Couleur.Bleu));
        paquetCartes.add(new Cartes("+2", Couleur.Bleu));
        paquetCartes.add(new Cartes(Couleur.Bleu, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Bleu, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Bleu, R.drawable.ic_action_rotate));
        paquetCartes.add(new Cartes(Couleur.Bleu, R.drawable.ic_action_rotate));


        paquetCartes.add(new Cartes("0", Couleur.Vert));
        paquetCartes.add(new Cartes("1", Couleur.Vert));
        paquetCartes.add(new Cartes("2", Couleur.Vert));
        paquetCartes.add(new Cartes("3", Couleur.Vert));
        paquetCartes.add(new Cartes("4", Couleur.Vert));
        paquetCartes.add(new Cartes("5", Couleur.Vert));
        paquetCartes.add(new Cartes("6", Couleur.Vert));
        paquetCartes.add(new Cartes("7", Couleur.Vert));
        paquetCartes.add(new Cartes("8", Couleur.Vert));
        paquetCartes.add(new Cartes("9", Couleur.Vert));
        paquetCartes.add(new Cartes("1", Couleur.Vert));
        paquetCartes.add(new Cartes("2", Couleur.Vert));
        paquetCartes.add(new Cartes("3", Couleur.Vert));
        paquetCartes.add(new Cartes("4", Couleur.Vert));
        paquetCartes.add(new Cartes("5", Couleur.Vert));
        paquetCartes.add(new Cartes("6", Couleur.Vert));
        paquetCartes.add(new Cartes("7", Couleur.Vert));
        paquetCartes.add(new Cartes("8", Couleur.Vert));
        paquetCartes.add(new Cartes("9", Couleur.Vert));
        paquetCartes.add(new Cartes("+2", Couleur.Vert));
        paquetCartes.add(new Cartes("+2", Couleur.Vert));
        paquetCartes.add(new Cartes(Couleur.Vert, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Vert, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Vert, R.drawable.ic_action_rotate));
        paquetCartes.add(new Cartes(Couleur.Vert, R.drawable.ic_action_rotate));


        paquetCartes.add(new Cartes("0", Couleur.Rouge));
        paquetCartes.add(new Cartes("1", Couleur.Rouge));
        paquetCartes.add(new Cartes("2", Couleur.Rouge));
        paquetCartes.add(new Cartes("3", Couleur.Rouge));
        paquetCartes.add(new Cartes("4", Couleur.Rouge));
        paquetCartes.add(new Cartes("5", Couleur.Rouge));
        paquetCartes.add(new Cartes("6", Couleur.Rouge));
        paquetCartes.add(new Cartes("7", Couleur.Rouge));
        paquetCartes.add(new Cartes("8", Couleur.Rouge));
        paquetCartes.add(new Cartes("9", Couleur.Rouge));
        paquetCartes.add(new Cartes("1", Couleur.Rouge));
        paquetCartes.add(new Cartes("2", Couleur.Rouge));
        paquetCartes.add(new Cartes("3", Couleur.Rouge));
        paquetCartes.add(new Cartes("4", Couleur.Rouge));
        paquetCartes.add(new Cartes("5", Couleur.Rouge));
        paquetCartes.add(new Cartes("6", Couleur.Rouge));
        paquetCartes.add(new Cartes("7", Couleur.Rouge));
        paquetCartes.add(new Cartes("8", Couleur.Rouge));
        paquetCartes.add(new Cartes("9", Couleur.Rouge));
        paquetCartes.add(new Cartes("+2", Couleur.Rouge));
        paquetCartes.add(new Cartes("+2", Couleur.Rouge));
        paquetCartes.add(new Cartes(Couleur.Rouge, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Rouge, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Rouge, R.drawable.ic_action_rotate));
        paquetCartes.add(new Cartes(Couleur.Rouge, R.drawable.ic_action_rotate));


        paquetCartes.add(new Cartes("0", Couleur.Jaune));
        paquetCartes.add(new Cartes("1", Couleur.Jaune));
        paquetCartes.add(new Cartes("2", Couleur.Jaune));
        paquetCartes.add(new Cartes("3", Couleur.Jaune));
        paquetCartes.add(new Cartes("4", Couleur.Jaune));
        paquetCartes.add(new Cartes("5", Couleur.Jaune));
        paquetCartes.add(new Cartes("6", Couleur.Jaune));
        paquetCartes.add(new Cartes("7", Couleur.Jaune));
        paquetCartes.add(new Cartes("8", Couleur.Jaune));
        paquetCartes.add(new Cartes("9", Couleur.Jaune));
        paquetCartes.add(new Cartes("1", Couleur.Jaune));
        paquetCartes.add(new Cartes("2", Couleur.Jaune));
        paquetCartes.add(new Cartes("3", Couleur.Jaune));
        paquetCartes.add(new Cartes("4", Couleur.Jaune));
        paquetCartes.add(new Cartes("5", Couleur.Jaune));
        paquetCartes.add(new Cartes("6", Couleur.Jaune));
        paquetCartes.add(new Cartes("7", Couleur.Jaune));
        paquetCartes.add(new Cartes("8", Couleur.Jaune));
        paquetCartes.add(new Cartes("9", Couleur.Jaune));
        paquetCartes.add(new Cartes("+2", Couleur.Jaune));
        paquetCartes.add(new Cartes("+2", Couleur.Jaune));
        paquetCartes.add(new Cartes(Couleur.Jaune, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Jaune, R.drawable.ic_action_bin));
        paquetCartes.add(new Cartes(Couleur.Jaune, R.drawable.ic_action_rotate));
        paquetCartes.add(new Cartes(Couleur.Jaune, R.drawable.ic_action_rotate));

        paquetCartes.add(new Cartes("+4", Couleur.Noire));
        paquetCartes.add(new Cartes("+4", Couleur.Noire));
        paquetCartes.add(new Cartes("+4", Couleur.Noire));
        paquetCartes.add(new Cartes("+4", Couleur.Noire));

        paquetCartes.add(new Cartes(Couleur.Noire, R.drawable.choix_couleur));
        paquetCartes.add(new Cartes(Couleur.Noire, R.drawable.choix_couleur));
        paquetCartes.add(new Cartes(Couleur.Noire, R.drawable.choix_couleur));
        paquetCartes.add(new Cartes(Couleur.Noire, R.drawable.choix_couleur));
    }

    private void affichageCarte(List<Joueur> joueursList, int i) {
        List<Cartes> mainjoueur = joueursList.get(i).getMainCartes();
        adaptateurMainJoueur = new AdaptateurMainJoueur(mainjoueur);
        recyclerView.setAdapter(adaptateurMainJoueur);
    }

    private void affichageTexte(List<Joueur> joueursList, int i) {
        pseudoJoueur.setText(joueursList.get(i).getNom());
    }

    public void lancementTour(List<Joueur> joueursList, int i) {
        setContentView(R.layout.page_noir);
        int j = i, finalJ;
        if (joueursList.size() > i) {
            j = i + 1;
        } else {
            j = 0;
        }

        finalJ = j;
        new AlertDialog.Builder(this)
                .setTitle("A qui le tour ?")
                .setMessage("C'est au tour de \"" + joueursList.get(i).getNom() + "\" de jouer")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.commencer, (dialog, which) -> {
                    Intent intent = new Intent(this, JouerActivite.class);

                    intent.putExtra("Position", finalJ);
                    startActivity(intent);
                })
                .show();
    }
}
