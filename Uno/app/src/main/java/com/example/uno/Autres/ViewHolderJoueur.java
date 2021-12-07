package com.example.uno.Autres;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

public class ViewHolderJoueur extends RecyclerView.ViewHolder {
    public TextView txt_view;

    public ViewHolderJoueur(@NonNull View itemView) {
        super(itemView);
        txt_view = itemView.findViewById(R.id.pseudoJoueur);
    }
}
