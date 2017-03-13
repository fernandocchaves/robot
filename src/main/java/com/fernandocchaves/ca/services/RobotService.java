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

        for (char ch: commands.toCharArray()) {
            if( ch == 'R' )
                angle = rightRotate.rotate(this.coordinates.getPosition());
            else if ( ch == 'L' )
                angle = leftRotate.rotate(this.coordinates.getPosition());
            else if(ch == 'M'){
                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.NORTH.getPosition()){
                    y = walkY.walk(this.coordinates.getY(), WalkTypeEnum.WalkType.INCREASE.getType()) ;
                }

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.EAST.getPosition()){
                    x = walkX.walk(this.coordinates.getX(), WalkTypeEnum.WalkType.INCREASE.getType()) ;
                }

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.SOUTH.getPosition()){
                    y = walkY.walk(this.coordinates.getY(), WalkTypeEnum.WalkType.DECREASE.getType()) ;
                }

                if(this.coordinates.getPosition() == CardinalPoinsEnum.CardinalPoins.WEST.getPosition()){
                    x = walkX.walk(this.coordinates.getX(), WalkTypeEnum.WalkType.DECREASE.getType()) ;
                }

                if( x < 0 || x > 5 || y < 0 || y > 5){
                    throw new IllegalArgumentException("Illegal parameter or exceeding the limit");
                }
            }
            else
                throw new IllegalArgumentException("Illegal parameter or exceeding the limit");

            this.coordinates.setPosition(angle);
            this.coordinates.setX(x);
            this.coordinates.setY(y);
        }

        return this.coordinates.toString();
    }

}
