package com.example.uno.Autres;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

import java.util.List;

public class AdaptateurMainJoueur extends RecyclerView.Adapter<ViewHolderMainJoueur> {
    public List<Cartes> mainJoueur;

    public AdaptateurMainJoueur(List<Cartes> cartesList) {
        this.mainJoueur = cartesList;
    }

    @NonNull
    @Override
    public ViewHolderMainJoueur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carte_uno, parent, false);
        return new ViewHolderMainJoueur(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderMainJoueur holder, int position) {
        Log.i("Couleur_Cartes", String.valueOf(mainJoueur.get(position).getCouleur()));
        Log.i("Couleur_Cartes", String.valueOf(mainJoueur.get(position).getNumero()));
        Cartes cartes = mainJoueur.get(position);
        switch (cartes.getCouleur()) {
            case Jaune:
                Log.i("Couleur", "Jaune");
                holder.view.setBackgroundColor(R.color.jauneUno);
                break;

            /*case Bleu:
                Log.i("Couleur", "Bleu");
                holder.view.setBackgroundColor(R.color.bleuUno);
                break;*/

            case Vert:
                Log.i("Couleur", "Vert");
                holder.view.setBackgroundColor(R.color.vertUno);
                break;

            case Noire:
                Log.i("Couleur", "Noire");
                holder.view.setBackgroundColor(R.color.noirUno);
                break;

            case Rouge:
                Log.i("Couleur", "Rouge");
                holder.view.setBackgroundColor(R.color.redUno);
                break;
        }

        if (cartes.getCarteSpe() != 0) {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.imageView.setImageResource(cartes.getCarteSpe());
        } else {
            holder.text1.setText(cartes.getNumero());
            holder.text2.setText(cartes.getNumero());
            holder.text3.setText(cartes.getNumero());
        }

        holder.itemView.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return mainJoueur.size();
    }
}
