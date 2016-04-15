package com.company.kovalenko;

import java.util.ArrayList;

public class Bouquet {
    public ArrayList<Flower> content;

    public Bouquet(ArrayList<Order> orders, Shop shop) {
        content = new ArrayList<>();
        for (Order order: orders) {

            if ((shop.checkForFlowerCount(order.getfName()) >= order.getCount()) && !Shop.pot.contains(order.getfName())) {
                int c = 0;
                for (Flower f: shop.flowers) {
                    if (f.getName().equals(order.getfName())){
                        content.add(f);
                        c++;
                        if (c==order.getCount())
                            break;
                    }
                }
            } else System.err.println("Sorry, but we don't have enough flowers to make your bouquet. " + "\n" +
                    "You can choose smth. else from our stock.");
        }

    }
}
