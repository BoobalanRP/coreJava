package in.boomibalan.fertagriboomi;

import java.time.LocalDate;

import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.service.UserService;
import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.service.TaskService;

public class App {

	public static void main(String[] args) {

		UserService userService = new UserService();

		try {
			User newUser = new User();
			newUser.setId(788755786);
			newUser.setFirstName("Boobalan");
			newUser.setLastName("Ravichandran");
			newUser.setEmail("rboomibaln459@gmail.com");
			newUser.setPassword("xyz12345");
			newUser.setActive(true);

			userService.create(newUser);
			userService.getAll();
			System.out.println(newUser.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Task
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
			// taskService.update();
			// taskService.delete();
			// taskService.findById();
			// taskService.getAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
