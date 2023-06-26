package in.boomibalan.fertagriboomi.service;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();
		
		for(int i=0; i<userList.length; i++) {
			System.out.println(userList[i]);
		}
		
		
		
		return userList;
	}
}
