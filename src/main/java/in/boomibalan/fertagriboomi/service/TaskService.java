package in.boomibalan.fertagriboomi.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import in.boomibalan.fertagriboomi.dao.TaskDAO;

import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.validator.TaskValidator;

public class TaskService {

	public Set<Task> getAll() {

		TaskDAO userDao = new TaskDAO();
		Set<Task> taskList = userDao.findAll();
		Iterator<Task> iterator = taskList.iterator();
		// int count = 0;
		while (iterator.hasNext()) {
			Task user = iterator.next();
			System.out.println(user);
			// System.out.println(count++);
		}
		return taskList;
	}

	public void create(Task newTask) throws Exception {
		TaskValidator.validate(newTask);
		TaskDAO userDao = new TaskDAO();
		userDao.create(newTask);

	}

	public void update(int id, Task newUpdate) {

//		Task newTask2 = new Task();
//		newTask2.setId(753);
//
//		String userInput = "30/02/2024";
//		LocalDate convertedDate = TaskService.convertToDate(userInput);
//		newTask2.setDueDate(convertedDate);
//		newTask2.setTaskName("Musiryl");
//		newTask2.setActive(true);

		TaskDAO taskDao = new TaskDAO();
		taskDao.update(id, newUpdate);

	}

	public void delete(int id) {
		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(id);
	}

	public Task findById(int newId) {
		TaskDAO taskDao = new TaskDAO();
		return taskDao.findById(newId);
	}

	public static LocalDate convertToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			return localDate;
		} catch (Exception e) {
			System.out.println("Invalid date format!");
			return null;
		}
	}

	public List<Task> findByDueDate(LocalDate date) {
		TaskDAO taskDao = new TaskDAO();
		return taskDao.findDueDate(date);
	}

}
