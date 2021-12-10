package com.example.uno.Autres;

public class Cartes {
    private String numero;
    private Couleur couleur;
    private int backgroundCarte;
    private boolean carteSpe;

    public Cartes(String numero, Couleur couleur, int backgroundCarte, boolean special) {
        this.numero = numero;
        this.couleur = couleur;
        this.backgroundCarte = backgroundCarte;
        this.carteSpe = special;
    }

    public String getNumero() {
        return numero;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public int getBackgroundCarte() {
        return backgroundCarte;
    }

    public boolean isCarteSpe() {
        return carteSpe;
    }
}
