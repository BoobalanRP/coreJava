package in.fertagriboomi.boomibalan;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import in.boomibalan.fertagriboomi.model.*;
import in.boomibalan.fertagriboomi.dao.*;
import in.boomibalan.fertagriboomi.exception.ValidationException;
import in.boomibalan.fertagriboomi.service.*;

public class TestGetAllTask {

	@Test
	public void getAllTasks() {
		TaskService taskservice = new TaskService();
		Set<Task> taskList = taskservice.getAll();
		System.out.println(taskList);

	}

	@Test
	public void testFindById() {
		TaskService taskservice = new TaskService();
		Task task = taskservice.findById(2);
		System.out.println(task);
	}

	@Test
	public void testUpdateTask() throws ValidationException {
		TaskService taskservice = new TaskService();
		Task task = new Task();

		// Use LocalDate for dueDate
		task.setDueDate(LocalDate.of(2024, 11, 15));
		task.setTaskName("Design the fence");

		taskservice.update(5, task);
	}

	@Test
	public void testDeleteTask() {
		TaskService taskservice = new TaskService();
		taskservice.delete(1);
	}

	@Test
	public void testFindDueDate() {
		TaskService taskservice = new TaskService();
		List<Task> task = taskservice.findByDueDate(LocalDate.parse("2023-10-29"));

		System.out.println(task);

	}

}
