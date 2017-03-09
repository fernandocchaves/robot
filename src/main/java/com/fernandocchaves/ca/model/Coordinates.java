package com.fernandocchaves.ca.model;


public class Coordinates {

    private int position;
    private int x;
    private int y;

    public Coordinates(){
        this.position = 0;
        this.x = 0;
        this.y = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.position + ")";
    }
}
