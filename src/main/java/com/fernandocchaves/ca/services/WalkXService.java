package com.fernandocchaves.ca.services;

import com.fernandocchaves.ca.enums.WalkTypeEnum;
import com.fernandocchaves.ca.services.interfaces.WalkInterface;
import java.lang.Override;

public class WalkXService implements WalkInterface {

    @Override
    public int walk(int position, int type) {

        if(type == WalkTypeEnum.WalkType.INCREASE.getType())
            return position + 1;
        else if(type == WalkTypeEnum.WalkType.DECREASE.getType())
            return position - 1;

        return position;
    }
}
