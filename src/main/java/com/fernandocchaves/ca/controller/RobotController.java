package com.fernandocchaves.ca.controller;

import com.fernandocchaves.ca.model.Coordinates;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RobotController {

    private Coordinates coordinates;

    public RobotController(){
        this.coordinates = new Coordinates();
    }

    @RequestMapping(path = "/rest/mars/{commands}", method = RequestMethod.POST)
    @ResponseBody
    String navigate(@PathVariable String commands)
    {
        String locate = "";
        for (char ch: commands.toCharArray()) {
            if(ch == 'R' || ch == 'L'){
                this.rotate(ch);
            }

            if(ch == 'M'){
                this.walk();
            }
        }

        if (this.coordinates.getPosition() == 0){
            locate = "N";
        }

        if (this.coordinates.getPosition() == 90){
            locate = "E";
        }

        if (this.coordinates.getPosition() == 180){
            locate = "S";
        }

        if (this.coordinates.getPosition() == 270){
            locate = "L";
        }

        return this.coordinates.toString();
    }

    void rotate( char command ){
        if(command == 'R'){
            if( this.coordinates.getPosition() == 270 )
                this.coordinates.setPosition(0);
            else
                this.coordinates.setPosition( this.coordinates.getPosition() + 90 );
        }

        if(command == 'L'){
            if( this.coordinates.getPosition() == 0 )
                this.coordinates.setPosition(270);
            else
                this.coordinates.setPosition( this.coordinates.getPosition() -  90);
        }
    }

    public void walk() {
        if(this.coordinates.getPosition() == 0){
            this.coordinates.setY( this.coordinates.getY() + 1 );
        }

        if(this.coordinates.getPosition() == 90){
            this.coordinates.setX( this.coordinates.getX() + 1 );
        }

        if(this.coordinates.getPosition() == 180){
            this.coordinates.setY( this.coordinates.getY() - 1 );
        }

        if(this.coordinates.getPosition() == 270){
            this.coordinates.setX( this.coordinates.getX() - 1 );
        }
    }
}
