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
public class RobotNoWalkTests {

	@Autowired
	private RobotService robotService;

	@Test
	public void testGet_returnLeftRotate_whenNoWalk() {
		Assert.assertEquals(robotService.navigate("L"), "(0, 0, W)");
	}

	@Test
	public void testGet_returnRightRotate_whenNoWalk() {
		Assert.assertEquals(robotService.navigate("R"), "(0, 0, E)");
	}

	@Test
	public void testGet_returnSouthRotate_whenNoWalk() {
		Assert.assertEquals(robotService.navigate("RR"), "(0, 0, S)");
	}
}
