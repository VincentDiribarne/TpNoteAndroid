package com.example.uno.Autres;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

public class ViewHolderMainJoueur extends RecyclerView.ViewHolder {
    public TextView text1, text2, text3;
    public ImageView imageView;
    public View view;

    public ViewHolderMainJoueur(@NonNull View itemView) {
        super(itemView);
        text1 = itemView.findViewById(R.id.textCarte);
        text2 = itemView.findViewById(R.id.textCarte2);
        text3 = itemView.findViewById(R.id.textCarte3);
        imageView = itemView.findViewById(R.id.imageUno);
        view = itemView.findViewById(R.id.backgroundCarte);
    }
}
