package in.boomibalan.fertagriboomi.util;

import java.time.LocalDate;

import in.boomibalan.fertagriboomi.exception.ValidationException;

public class StringUtil {
	public static void rejectIfInvalidString(String input, String inputName) throws ValidationException {

		if (input == null || "".equals(input.trim())) {

			throw new ValidationException(inputName.concat(" cannot be Null or Empty"));

		}
	}

	public static void rejectIfInvalidDate(LocalDate input, String inputName) throws ValidationException {
		LocalDate currentDate = LocalDate.now();

		if (input.isBefore(currentDate)) {

			throw new ValidationException(inputName.concat(" can not be in the Past"));

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
