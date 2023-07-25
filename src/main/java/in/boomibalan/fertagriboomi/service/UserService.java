package in.boomibalan.fertagriboomi.service;

import java.util.Iterator;
import java.util.Set;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.exception.ValidationException;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.validator.UserValidator;

public class UserService {
//	private UserDAO userDao;

//	public UserService() {
//		this.userDao = new UserDAO(); // Initialize userDao instance in the constructor
//	}

	public Set<User> getAll() {
		UserDAO userDao = new UserDAO();
		Set<User> userList = userDao.findAll();
		Iterator<User> iterator = userList.iterator();
		// int count = 0;
		while (iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user);
			// System.out.println(count++);
		}
		return userList;
	}

	public void create(User newUser) throws Exception {
		UserDAO userDao = new UserDAO();
		UserValidator.validate(newUser);
		userDao.create(newUser);
	}

	public void update(int id, User newUpdate) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		UserValidator.validate(newUpdate);
		userDAO.update(id, newUpdate);
	}

	public void delete(int id) {
		UserDAO userDao = new UserDAO();
		userDao.delete(id);
	}

	public User findById(int newId) {
		UserDAO userDao = new UserDAO();
		return userDao.findById(newId);

	}

	public User findByEmail(String Email) {
		UserDAO userDao = new UserDAO();
		return userDao.findByEmail(Email);
	}
}
