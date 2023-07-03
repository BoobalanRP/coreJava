package in.boomibalan.fertagriboomi.validator;

import in.boomibalan.fertagriboomi.model.User;

public class UserValidator {

	public static void validate(User user) throws Exception {

		if (user == null) {
			throw new Exception("Invalid User input");
		}
		if (user.getEmail() == null || ("").equals(user.getEmail().trim())) {
			throw new Exception("Email cannot be null or empty");
		}
		if (user.getPassword() == null || ("").equals(user.getEmail().trim())) {
			throw new Exception("Password cannot be null or empty");
		}
		if (user.getFirstName() == null || ("").equals(user.getEmail().trim())) {
			throw new Exception("Firstname cannot be null or empty");
		}
	}

}
