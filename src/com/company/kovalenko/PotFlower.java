package com.company.kovalenko;

public class PotFlower extends Flower {

    public PotFlower(int freshness) {
        super(freshness);
    }

    public PotFlower(int freshness, String name) {
        super(freshness, name);
    }

    @Override
    public int getFreshness() {
        return super.getFreshness();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public boolean isFresh() {
        return super.isFresh();
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        if(isFresh())
            return String.format("PotFlower called " + getName() + " is fresh with freshness %d", getFreshness());
        else
            return String.format("PotFlower called " + getName() + " is not fresh with freshness %d", getFreshness());
    }
}
