package in.boomibalan.fertagriboomi.dao;

import in.boomibalan.fertagriboomi.model.User;

public class UserDAO {

/**
 * 
 * @return
 */
	public User[] findAll() {

		User[] userList = UserList.listOfUsers;
		return userList;

	}
	/**
	 * 
	 * @param newUser
	 */

	public void create(User newUser) {

		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				arr[i] = newUser;
//        		 user = newUser;
				break;
			}
		}

	}
	
	

	/**

	Updates the user details based on the provided ID.
	@param id The ID of the user to be updated.
	@param updatedUser The updated User object containing the new details.
	*/
//	update the user details
	public void update(int id, User updatedUser) {
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}

			if (user.getId() == id) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setPassword(updatedUser.getPassword());

				break;

			}

		}

	}
	
//	delete user details
	public void delete(int userId) {
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			
			if (user.getId() == userId) {
				user.setActive(false);
				break;
			}
		}
	}
	
	public User findById(int userId) {
		User[] userList = UserList.listOfUsers;
		User userMatch = null;
		
	

		for (int i = 0; i < userList.length; i++) {
			User user = userList[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}
	
	

}
