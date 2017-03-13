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
public class RobotWalkYTests {

	@Autowired
	private RobotService robotService;

	@Test
	public void testGet_returnNoRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("M"), "(0, 1, N)");
	}

	@Test
	public void testGet_returnLeftRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("ML"), "(0, 1, W)");
	}

	@Test
	public void testGet_returnRightRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("MR"), "(0, 1, E)");
	}

	@Test
	public void testGet_returnSouthRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("MRR"), "(0, 1, S)");
	}

	@Test
	public void testGet_returnXYMove_whenWalk() {
		Assert.assertEquals(robotService.navigate("MRMR"), "(1, 1, S)");
	}
}
