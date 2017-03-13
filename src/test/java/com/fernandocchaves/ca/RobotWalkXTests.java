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
public class RobotWalkXTests {

	@Autowired
	private RobotService robotService;

	@Test
	public void testGet_returnRightRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("MRM"), "(1, 1, E)");
	}

	@Test
	public void testGet_returnLeftRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("MRMLM"), "(1, 2, N)");
	}

	@Test
	public void testGet_returnSouthRotate_whenWalk() {
		Assert.assertEquals(robotService.navigate("MRRM"), "(0, 0, S)");
	}
}
