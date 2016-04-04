package com.company.kovalenko;

public class ThornsFlower extends StemFlower {

    ThornsFlower(int f, int s){
        super(f, s);
    }

    public ThornsFlower(int freshness, String name) {
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
    public int getStemLength() {
        return super.getStemLength();
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
            return String.format("ThornsFlower called " + getName() + " is fresh with freshness %d", getFreshness());
        else
            return String.format("ThornsFlower called " + getName() + " is not fresh with freshness %d", getFreshness());
    }
}
