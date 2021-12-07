package com.example.uno.Autres;

import java.util.List;

public class Joueur {
    public String nom;
    public int scores;
    public List<Cartes> mainCartes;

    public Joueur(String nom, int scores) {
        this.nom = nom;
        this.scores = scores;
    }

    public String getNom() {
        return nom;
    }

    public int getScores() {
        return scores;
    }

    public List<Cartes> getMainCartes() {
        return mainCartes;
    }

    //Setters
    public void setMainCartes(List<Cartes> mainCartes) {
        this.mainCartes = mainCartes;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
