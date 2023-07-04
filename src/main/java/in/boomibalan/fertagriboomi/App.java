package in.boomibalan.fertagriboomi;

import java.time.LocalDate;

import in.boomibalan.fertagriboomi.dao.UserDAO;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.service.TaskService;
import in.boomibalan.fertagriboomi.service.UserService;

public class App {

	public static void main(String[] args) {

		try {
			UserService userService = new UserService();

			User newUser = new User();
			newUser.setId(788755786);
			newUser.setFirstName("Boobalan");
			newUser.setLastName("Ravichandran");
			newUser.setEmail("rboomibaln459@gmail.com");
			newUser.setPassword("xyz12345");
			newUser.setActive(true);

			userService.create(newUser);
//			userService.getAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

//		task

		try {
			TaskService taskService = new TaskService();

			Task newTask = new Task();

			newTask.setId(753);
			newTask.setTaskName("Locogy");
			
			
			String userInput = "23/10/2023";
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			
			newTask.setActive(true);

			taskService.create(newTask);
			taskService.update();
			taskService.delete();
			taskService.findById();
			taskService.getAll();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
