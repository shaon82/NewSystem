package com.shaon.NHSystem;

import com.shaon.NHSystem.model.Task;
import com.shaon.NHSystem.model.User;
import com.shaon.NHSystem.service.TaskService;
import com.shaon.NHSystem.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhSystemApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@Before
	public void initdb(){
		{
			User user = new User("testUser@mail.com", "testUser", "123456");
			userService.createUser(user);
		}
		{
			User user = new User("testAdmin@mail.com","testAdmin","123456");
			userService.createUser(user);
		}

		Task userTask = new Task("25/02/2019","00:11","11:00","you need to work task");
		User user = userService.findOneByEamil("testUser@mail.com");
		taskService.addTask(userTask,user);
	}

	@Test
	public void testUser(){
		User user = userService.findOneByEamil("testUser@mail.com");
		Assert.assertNotNull(user);
		User admin = userService.findOneByEamil("testAdmin@mail.com");
		Assert.assertEquals(admin.getEmail(),"testAdmin@mail.com");
	}

	@Test
	public void testTask(){
		User user = userService.findOneByEamil("testUser@mail.com");
		List<Task>task = taskService.findUserByTask(user);
		Assert.assertNotNull(task);
	}

}
