package com.fernandocchaves.ca.model;


import com.fernandocchaves.ca.enums.CardinalPoinsEnum;

public class Coordinates {

    private int position;
    private String locale;
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

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.getLocale() + ")";
    }
}
