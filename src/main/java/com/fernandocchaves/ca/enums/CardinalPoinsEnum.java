package com.fernandocchaves.ca.enums;

public class CardinalPoinsEnum {

    public enum CardinalPoins {

        NORTH("N", 0),
        EAST("E", 90),
        SOUTH("S", 180),
        WEST("W", 270);

        private String locale;
        private int position;

        CardinalPoins(String locale, int position){
            this.locale = locale;
            this.position = position;
        }

        public String getLocale() {
            return locale;
        }

        public int getPosition() {
            return position;
        }
    }
}
