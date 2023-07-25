package in.fertagriboomi.boomibalan;

import in.boomibalan.fertagriboomi.model.Task;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.boomibalan.fertagriboomi.exception.ValidationException;
import in.boomibalan.fertagriboomi.service.TaskService;

public class TestCreateTask {

	@Test
	public void testCreateTaskWithValidData() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		String userInput = "13/10/2024";
		newTask.setTaskName("Jumping");
		LocalDate convertedDate = TaskService.convertToDate(userInput);
		newTask.setDueDate(convertedDate);
		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});
	}

	@Test
	public void testCreateTaskWithInvalidData() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String expectedMessage = "Invalid Task input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithTaskNameNull() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(12345);
			String userInput = "23/07/2023";
			newTask.setTaskName(null);
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.create(newTask);
		});
		String expectedMessage = "Taskname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithTaskNameEmpty() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(12345);
			String userInput = "23/07/2023";
			newTask.setTaskName("");
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.create(newTask);
		});
		String expectedMessage = "Taskname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithInvalidDate() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(99999);
			String userInput = "23/07/2022";
			newTask.setTaskName("Close The Door");
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.create(newTask);
		});
		String expectedMessage = "Due Date can not be in the Past";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}
