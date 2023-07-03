package in.fertagriboomi.boomibalan;

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

	@Test
	public void testUserEmailWithInvalideDataInput() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail(null);
		newUser.setPassword("xyz12345");
		newUser.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser);
		});
		
		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
}
