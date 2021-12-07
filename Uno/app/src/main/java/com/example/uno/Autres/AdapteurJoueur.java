package com.example.uno.Autres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.uno.R;
import java.util.List;

public class AdapteurJoueur extends RecyclerView.Adapter<ViewHolderJoueur>{
    public List<Joueur> joueurs;

    public AdapteurJoueur(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    @NonNull
    @Override
    public ViewHolderJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pseudo, parent, false);
        return new ViewHolderJoueur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderJoueur holder, int position) {
        Joueur joueur = joueurs.get(position);
        holder.txt_view.setText(joueur.getNom());
    }

    @Override
    public int getItemCount() {
        return joueurs.size();
    }
}
