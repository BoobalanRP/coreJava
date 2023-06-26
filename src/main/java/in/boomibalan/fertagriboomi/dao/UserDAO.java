package in.boomibalan.fertagriboomi.dao;

import in.boomibalan.fertagriboomi.model.User;

public class UserDAO {

	public User[] findAll() {
		
		User[] userList = UserList.listOfUsers;
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
		UserList.listOfUsers[0] = newUser;

	}

}
