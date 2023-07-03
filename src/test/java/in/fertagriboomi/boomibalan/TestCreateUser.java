package in.fertagriboomi.boomibalan;


import in.boomibalan.fertagriboomi.exception.ValidationException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValideInput() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail("rboomibaln459@gmail.com");
		newUser.setPassword("xyz12345");
		newUser.setActive(true);
		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});

	}

	@Test
	public void testCreateUSerWithInvalidInput() {
		UserService userService = new UserService();
		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "Invalid User input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

//	email
	@Test
	public void testUserEmailWithNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail(null);
		newUser.setPassword("xyz12345");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "email cannot be empty or null";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	
	@Test
	public void testUserEmailWithEmptyString() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail("");
		newUser.setPassword("xyz12345");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "email cannot be empty or null";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
//	password
	@Test
	public void testUserPasswordWithEmptyString() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail("rboomibalan459@gmail.com");
		newUser.setPassword("");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "password cannot be empty or null";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserPasswordWithNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail("rboomibalan459@gmail.com");
		newUser.setPassword(null);
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "password cannot be empty or null";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
//	firstName
	@Test
	public void testUserFirstNameWithEmptyString() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("");
		newUser.setLastName("Ravichandran");
		newUser.setEmail("rboomibalan459@gmail.com");
		newUser.setPassword("xyz12345");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "firstName cannot be empty or null";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUserFirstNameWithNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName(null);
		newUser.setLastName("Ravichandran");
		newUser.setEmail("rboomibalan459@gmail.com");
		newUser.setPassword("xyz12345");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "firstName cannot be empty or null";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
}
