package com.company.kovalenko;

public class StemFlower extends Flower {

    private int stemLength;

    public StemFlower(int f, int stemLength){
        super(f);
        this.stemLength = stemLength;
    }

    public StemFlower(int freshness, String name) {
        super(freshness, name);
    }

    public int getStemLength() {
        return stemLength;
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
}
