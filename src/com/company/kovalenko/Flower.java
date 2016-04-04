package com.company.kovalenko;

public class Flower implements Comparable{

    private int freshness;
    private int price;
    private boolean fresh;
    private String name;
    private boolean sold = false;

    public Flower(int freshness) {
        this.freshness = freshness;
    }
    public Flower(int freshness, String name) {
        this.freshness = freshness;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFresh() {
        fresh = freshness != 0;
        return fresh;
    }

    @Override
    public int compareTo(Object o) {
        Flower other = (Flower) o;
        return Integer.compare(freshness, other.freshness);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", freshness=" + freshness +
                '}';
    }
}
