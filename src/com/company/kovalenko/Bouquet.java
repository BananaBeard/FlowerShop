package com.company.kovalenko;

import java.util.ArrayList;

public class Bouquet {
    public ArrayList<Flower> content;

    public Bouquet(int thornsNeeded, int noThornsNeeded, ArrayList<Flower> flowers) {

        int tCounter = 0;
        int nCounter = 0;
        boolean tFull = false;
        boolean nFull = false;
        content = new ArrayList<>();

        for (Flower f : flowers) {
            if (!tFull && (f instanceof ThornsFlower) && (thornsNeeded != 0)) {
                content.add(f);
                tCounter++;
                if (tCounter == thornsNeeded) {
                    tFull = true;
                }
            }
            else if (!nFull && (f instanceof NoThornsFlower) && (noThornsNeeded != 0)) {
                content.add(f);
                nCounter++;
                if (nCounter == noThornsNeeded) {
                    nFull = true;
                }
            }
        }
    }
}
