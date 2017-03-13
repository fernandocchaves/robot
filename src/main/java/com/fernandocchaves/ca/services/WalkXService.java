package com.fernandocchaves.ca.services;

import com.fernandocchaves.ca.enums.WalkTypeEnum;
import com.fernandocchaves.ca.services.interfaces.WalkInterface;
import java.lang.Override;

public class WalkXService implements WalkInterface {

    @Override
    public int walk(int position, WalkTypeEnum type) {

        if(type == WalkTypeEnum.INCREASE)
            return position + 1;
        else if(type == WalkTypeEnum.DECREASE)
            return position - 1;

        return position;
    }
}
