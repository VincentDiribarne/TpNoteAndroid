package com.example.uno.Autres;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

public class ViewHolderMainJoueur extends RecyclerView.ViewHolder {
    public ImageView view, defausse;

    public ViewHolderMainJoueur(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.backgroundCarte);
        defausse = itemView.findViewById(R.id.defausse);
    }
}
