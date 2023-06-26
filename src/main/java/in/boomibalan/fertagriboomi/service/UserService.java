package in.boomibalan.fertagriboomi.service;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.dao.UserList;
import in.boomibalan.fertagriboomi.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}

		return userList;
	}
	
	public void create() {

		User newUser = new User();
		newUser.setId(788755786);
		newUser.setFirstName("Boobalan");
		newUser.setLastName("Ravichandran");
		newUser.setEmail("rboomibaln459@gmail.com");
		newUser.setPassword("xyz12345");
		newUser.setActive(true);
		
		
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);

	}
}
