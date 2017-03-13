package com.fernandocchaves.ca.controller;

import com.fernandocchaves.ca.enums.CardinalPoinsEnum;
import com.fernandocchaves.ca.model.Coordinates;
import com.fernandocchaves.ca.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class RobotController {

    @Autowired
    RobotService robot;

    @RequestMapping(path = "/rest/mars/{commands}", method = RequestMethod.POST)
    @ResponseBody
    String navigate(@PathVariable String commands) {
        return robot.navigate(commands);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
