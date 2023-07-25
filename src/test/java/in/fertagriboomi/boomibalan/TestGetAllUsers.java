package in.fertagriboomi.boomibalan;

import java.util.*;

import org.junit.jupiter.api.Test;

import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.service.*;;

public class TestGetAllUsers {

	@Test
	public void getAllUsers() {
		UserService userservice = new UserService();
		Set<User> userList = userservice.getAll();

		System.out.println(userList);

	}

	@Test
	public void testFindById() {
		UserService userservice = new UserService();
		User user = userservice.findById(1);
		System.out.println(user);
	}
}
