package in.fertagriboomi.boomibalan;

import java.util.*;

import org.junit.jupiter.api.Test;

import in.boomibalan.fertagriboomi.exception.ValidationException;
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

	@Test
	public void testUpdateUser() throws ValidationException {
		UserService userservice = new UserService();
//		User user1 = new User();
//		user1.setFirstName("vignesh");
//		user1.setLastName("ramachandran");
//		userservice.update(2, user1);

		User newUser = new User();

		newUser.setFirstName("Vignesh");
		newUser.setLastName("Ramachandran");
		newUser.setEmail("rboomibalan459@gmail.com");
		newUser.setPassword("xyz12345");
		userservice.update(2, newUser);

	}

	@Test
	public void testDeleteUser() {
		UserService userservice = new UserService();
		userservice.delete(1);
	}

	@Test
	public void testFindByEmail() {
		UserService userservice = new UserService();
		User user = userservice.findByEmail("vijay@example.com");

		System.out.println(user);

	}
}
