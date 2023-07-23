package in.boomibalan.fertagriboomi.dao;

import java.util.Set;

import in.boomibalan.fertagriboomi.interfaces.UserInterface;
import in.boomibalan.fertagriboomi.model.User;

public class UserDAO implements UserInterface {

	@Override
	public Set<User> findAll() {
		Set<User> userList = UserList.listOfUsers; // collecting data from UserList class.
		return userList;
	}

	@Override
	public void create(User newUser) {
		Set<User> userList = UserList.listOfUsers;
		userList.add(newUser);
	}

	@Override
	public void update(int id, User updatedUser) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == id) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setEmail(updatedUser.getEmail());
				user.setPassword(updatedUser.getPassword());
				user.setActive(true);
				break;
			}
		}
	}

	@Override
	public void delete(int id) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user != null && user.getId() == id) {
				user.setActive(false);
			}
		}
	}

	@Override
	public User findById(int id) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user != null && user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user != null && user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

	@Override
	public int count() {
		Set<User> userList = UserList.listOfUsers;
		int countOfUsers = 0;
		for (User user : userList) {
			if (user != null) {
				countOfUsers += 1;
			}
		}

		return countOfUsers;
	}
}
