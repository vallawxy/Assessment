package com.example.Assessment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssessmentApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void testConextLoaded() {
		Assert.assertNotNull(context);
	}

}
