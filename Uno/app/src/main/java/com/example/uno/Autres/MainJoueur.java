package com.example.uno.Autres;

import java.util.ArrayList;
import java.util.List;

public class MainJoueur {
    private List<Cartes> mainJoueur = new ArrayList<>();

    public List<Cartes> getMainJoueur() {
        return mainJoueur;
    }

    public void setMainJoueur(List<Cartes> mainJoueur) {
        this.mainJoueur = mainJoueur;
    }
}
