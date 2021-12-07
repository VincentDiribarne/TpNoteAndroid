package com.example.uno.Autres;

import java.util.Random;

public class NombreAleatoire {

    public static int getNombreRandom(int min, int max) {
        if (min >= max) {
            int temp = max;
            max = min;
            min = temp;
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
