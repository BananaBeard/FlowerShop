package com.company.kovalenko;

public class Order {
    private int count;
    private String fName;

    public Order(String fName, int count) {
        this.count = count;
        this.fName = fName;
    }

    public int getCount() {
        return count;
    }

    public String getfName() {
        return fName;
    }
}
