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
        if (this.getPosition() == CardinalPoinsEnum.CardinalPoins.NORTH.getPosition()){
            this.locale = CardinalPoinsEnum.CardinalPoins.NORTH.getLocale();
        }

        if (this.getPosition() == CardinalPoinsEnum.CardinalPoins.EAST.getPosition()){
            this.locale = CardinalPoinsEnum.CardinalPoins.EAST.getLocale();
        }

        if (this.getPosition() == CardinalPoinsEnum.CardinalPoins.SOUTH.getPosition()){
            this.locale = CardinalPoinsEnum.CardinalPoins.SOUTH.getLocale();
        }

        if (this.getPosition() == CardinalPoinsEnum.CardinalPoins.WEST.getPosition()){
            this.locale = CardinalPoinsEnum.CardinalPoins.WEST.getLocale();
        }
        return this.locale;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.getLocale() + ")";
    }
}
