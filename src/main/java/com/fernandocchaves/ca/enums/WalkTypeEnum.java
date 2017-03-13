package com.fernandocchaves.ca.enums;

public class WalkTypeEnum {

    public enum WalkType {

        DECREASE(0),
        INCREASE(1);

        private int type;

        WalkType(int type){
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
