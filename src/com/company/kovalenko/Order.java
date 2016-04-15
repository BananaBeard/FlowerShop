package com.company.kovalenko;

public class Order {
    private int count;
    private String fName;

    public Order(String fName, int count) throws RequestedFlowerNotInListException{
        if ((Shop.thorn.contains(fName)) || (Shop.nothorn.contains(fName)) || (Shop.pot.contains(fName))) {
            this.count = count;
            this.fName = fName;
        } else throw new RequestedFlowerNotInListException("Flower called " + fName + " not found.", fName);
    }

    public int getCount() {
        return count;
    }

    public String getfName() {
        return fName;
    }
}
