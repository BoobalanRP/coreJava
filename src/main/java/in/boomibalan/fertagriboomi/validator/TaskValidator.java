package in.boomibalan.fertagriboomi.validator;

import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.util.StringUtil;
import in.boomibalan.fertagriboomi.exception.ValidationException;

public class TaskValidator {
	public static void validate(Task task) throws Exception {
		if (task == null) {
			throw new ValidationException("Invalid Task input");
		}
		
//		if (task.getTaskName() == null || ("").equals(task.getTaskName().trim())) {
//		throw new Exception("Email cannot be null or empty");
//	   }
		
		StringUtil.rejectIfInvalidString(task.getTaskName(), "Taskname");
		
		StringUtil.rejectIfInvalidDate(task.getDueDate(), "Due Date");
//		StringUtil.rejectIfInvalidString(task.getDueDate() , "duedate");
		
	}
	

}
