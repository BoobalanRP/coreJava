package in.boomibalan.fertagriboomi.service;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.dao.UserList;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.validator.UserValidator;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {

			System.out.println(userList[i]);

		}

		return userList;
	}

	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);

		UserDAO userDao = new UserDAO();
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

		UserDAO userDao = new UserDAO();
		userDao.update(788755786, newUser2);

	}

//	delete user
	public void delete() {
		UserDAO userDao = new UserDAO();
		userDao.delete(788755786);
	}

}
