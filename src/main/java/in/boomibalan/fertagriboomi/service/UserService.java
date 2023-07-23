package in.boomibalan.fertagriboomi.service;

import java.util.Set;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.validator.UserValidator;

public class UserService {
	private UserDAO userDao;

	public UserService() {
		this.userDao = new UserDAO(); // Initialize userDao instance in the constructor
	}

	public Set<User> getAll() {
		Set<User> userList = userDao.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
		return userList;
	}

	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);
		userDao.create(newUser);
	}

	public void update() {
		User newUser2 = new User();
		newUser2.setId(788755786);
		newUser2.setFirstName("Surya");
		newUser2.setLastName("Umapathy");
		newUser2.setEmail("rboomibaln459@gmail.com");
		newUser2.setPassword("xyz12345");
		newUser2.setActive(true);

		userDao.update(788755786, newUser2);
	}

	public void delete() {
		userDao.delete(788755786);
	}
}
