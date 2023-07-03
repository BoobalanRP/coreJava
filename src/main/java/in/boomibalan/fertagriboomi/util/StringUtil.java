package in.boomibalan.fertagriboomi.util;

import in.boomibalan.fertagriboomi.exception.ValidationException;

public class StringUtil {
	public static void rejectIfInvalidString(String input, String inputName) throws ValidationException {

		if (input == null || "".equals(input.trim())) {

			throw new ValidationException(inputName.concat(" cannot be empty or null"));

		}
	}

	public static boolean isValidString(String input) {

		if (input == null || "".equals(input.trim())) {

			return false;

		}
		return true;
	}

	public static boolean isInValidString(String input) {

		if (input == null || "".equals(input.trim())) {

			return false;

		}
		return true;
	}
}
