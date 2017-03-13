package com.fernandocchaves.ca;

import com.fernandocchaves.ca.services.RobotService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotExceptionTests {

    @Autowired
    private RobotService robotService;

    @Test
    public void testGet_returnException_whenInvalidParamters() {
        Throwable e = null;

        try {
            robotService.navigate("AAA");
        } catch (Throwable ex) {
            e = ex;
        }

        Assert.assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public void testGet_returnException_whenExceedingParamters() {
        Throwable e = null;

        try {
            robotService.navigate("MMMMMMMMMMMMMMMMMMMMMMMM");
        } catch (Throwable ex) {
            e = ex;
        }

        Assert.assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public void testGet_returnException_whenNegativeX() {
        Throwable e = null;

        try {
            robotService.navigate("LM");
        } catch (Throwable ex) {
            e = ex;
        }

        Assert.assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public void testGet_returnException_whenNegativeY() {
        Throwable e = null;

        try {
            robotService.navigate("RRM");
        } catch (Throwable ex) {
            e = ex;
        }

        Assert.assertTrue(e instanceof IllegalArgumentException);
    }
}
