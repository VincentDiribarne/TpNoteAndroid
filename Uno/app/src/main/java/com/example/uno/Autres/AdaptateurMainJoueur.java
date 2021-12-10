package com.example.uno.Autres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.Activity.JouerActivite;
import com.example.uno.Activity.LancementPartieActivity;
import com.example.uno.R;

import java.util.List;

public class AdaptateurMainJoueur extends RecyclerView.Adapter<ViewHolderMainJoueur> {
    private List<Cartes> mainJoueur;
    private Defausse defausse = LancementPartieActivity.defausse;
    private JouerActivite jouerActivite = new JouerActivite();

    public AdaptateurMainJoueur(List<Cartes> cartesList) {
        this.mainJoueur = cartesList;
    }

    @NonNull
    @Override
    public ViewHolderMainJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carte_uno, parent, false);
        return new ViewHolderMainJoueur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMainJoueur holder, int position) {
        holder.view.setBackgroundResource(mainJoueur.get(position).getBackgroundCarte());

        Cartes cartes = mainJoueur.get(position);
        List<Cartes> getDefausse = defausse.getDefausse();

        //Enleve la carte de la liste selon une condition
        holder.itemView.setOnClickListener(v -> {
            if (cartes.getCouleur() == defausse.getDefausse().get(defausse.getDefausse().size() - 1).getCouleur() || cartes.getNumero() == defausse.getDefausse().get(defausse.getDefausse().size() - 1).getNumero()) {
                getDefausse.add(mainJoueur.remove(position));
                defausse.setDefausse(getDefausse);

                jouerActivite.setMainJoueur(mainJoueur);
                jouerActivite.setDefausse(defausse);

                return;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainJoueur.size();
    }
}
