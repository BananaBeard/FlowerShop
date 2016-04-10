package com.company.kovalenko;

import java.util.ArrayList;

public class Bouquet {
    public ArrayList<Flower> content;

    public Bouquet(ArrayList<Order> orders, Shop shop) throws RequestedFlowerNotInListException{

        for (Order order: orders) {
            if ((Shop.thorn.contains(order.getfName())) || (Shop.nothorn.contains(order.getfName()))) {
                if (shop.checkForFlowerCount(order.getfName()) <= order.getCount()) {
                    for (Flower f: shop.flowers) {
                        if (f.getName().equals(order.getfName()))
                            content.add(f);
                    }
                } else System.err.println("Sorry, but we don't have enough flowers to make your bouquet. " + "\n" +
                        "You can choose smth. else from our stock.");
            } else throw new RequestedFlowerNotInListException();
        }

    }

    /*public Bouquet(int thornsNeeded, int noThornsNeeded, ArrayList<Flower> flowers) throws RequestedFlowerNotInListException{

        if ((thornsNeeded <= Shop.thornsCount) || (noThornsNeeded <= Shop.noThornsCount)) {
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
        } else {
            throw new IllegalArgumentException();
        }
    }*/
}
