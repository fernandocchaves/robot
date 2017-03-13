package com.fernandocchaves.ca.services;

import com.fernandocchaves.ca.enums.CardinalPoinsEnum;
import com.fernandocchaves.ca.enums.WalkTypeEnum;
import com.fernandocchaves.ca.model.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    private Coordinates coordinates;
    private LeftRotateService leftRotate;
    private RightRotateService rightRotate;
    private WalkXService walkX;
    private WalkYService walkY;

    private final static char ROTATE_TO_RIGHT = 'R';
    private final static char ROTATE_TO_LEFT = 'L';
    private final static char MOVE = 'M';

    public RobotService(LeftRotateService leftRotate,
                        RightRotateService rightRotate,
                        WalkXService walkX,
                        WalkYService walkY){

        this.leftRotate = leftRotate;
        this.rightRotate = rightRotate;
        this.walkX = walkX;
        this.walkY = walkY;
    }

    public String navigate(String commands){

        this.coordinates = new Coordinates();
        int angle = 0;
        int x = 0;
        int y = 0;
        String locale = "";

        for (char command: commands.toCharArray()) {
            if( command == ROTATE_TO_RIGHT )
                angle = rightRotate.rotate(this.coordinates.getPosition());

            else if ( command == ROTATE_TO_LEFT )
                angle = leftRotate.rotate(this.coordinates.getPosition());

            else if(command == MOVE){

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.NORTH.getPosition())
                    y = walkY.walk(this.coordinates.getY(), WalkTypeEnum.INCREASE);

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.EAST.getPosition())
                    x = walkX.walk(this.coordinates.getX(), WalkTypeEnum.INCREASE);

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.SOUTH.getPosition())
                    y = walkY.walk(this.coordinates.getY(), WalkTypeEnum.DECREASE);

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.WEST.getPosition())
                    x = walkX.walk(this.coordinates.getX(), WalkTypeEnum.DECREASE);

                if( x < 0 || x > 5 || y < 0 || y > 5)
                    throw new IllegalArgumentException("Illegal parameter or exceeding the limit");
            }
            else
                throw new IllegalArgumentException("Illegal parameter or exceeding the limit");

            this.coordinates.setPosition(angle);
            this.coordinates.setX(x);
            this.coordinates.setY(y);
        }

        locale = this.setLocale(this.coordinates.getPosition());
        this.coordinates.setLocale(locale);

        return this.coordinates.toString();
    }

    private String setLocale(int position){
        String locale = "";

        if (position == CardinalPoinsEnum.CardinalPoins.NORTH.getPosition())
            locale = CardinalPoinsEnum.CardinalPoins.NORTH.getLocale();

        if (position == CardinalPoinsEnum.CardinalPoins.EAST.getPosition())
            locale = CardinalPoinsEnum.CardinalPoins.EAST.getLocale();

        if (position == CardinalPoinsEnum.CardinalPoins.SOUTH.getPosition())
            locale = CardinalPoinsEnum.CardinalPoins.SOUTH.getLocale();

        if (position == CardinalPoinsEnum.CardinalPoins.WEST.getPosition())
            locale = CardinalPoinsEnum.CardinalPoins.WEST.getLocale();

        return locale;

    }

}
