package com.fernandocchaves.ca.services;

import com.fernandocchaves.ca.services.interfaces.RotateInterface;
import org.springframework.stereotype.Service;
import java.lang.Override;

@Service
public class LeftRotateService implements RotateInterface {

    private int angle;

    @Override
    public int rotate(int angle) {

        if( angle == 0 )
            this.angle = 270;
        else
            this.angle = angle - 90 ;

        return this.angle;
    }
}
