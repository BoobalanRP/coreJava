package in.boomibalan.fertagriboomi;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.service.UserService;

public class App {

	public static void main(String[] args) {

		try {
			UserService userService = new UserService();

			User newUser = new User();
			newUser.setId(788755786);
			newUser.setFirstName("Boobalan");
			newUser.setLastName("Ravichandran");
			newUser.setEmail("rboomibaln459@gmail.com");
			newUser.setPassword("xyz12345");
			newUser.setActive(true);

			userService.create(newUser);
			userService.getAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
