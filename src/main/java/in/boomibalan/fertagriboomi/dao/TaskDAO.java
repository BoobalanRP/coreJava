package in.boomibalan.fertagriboomi.dao;

import java.util.Set;

import in.boomibalan.fertagriboomi.interfaces.TaskInterface;
import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.model.User;

public class TaskDAO implements TaskInterface {

	public Set<Task> findAll() {
		Set<Task> taskList = TaskList.listOfTasks;
		return taskList;
	}

	public void create(Task newList) {
		Set<Task> arrList = TaskList.listOfTasks;
		for (Task task : arrList) {
			Task taskArr = task;
			if (taskArr == null) {
				task = newList;
				break;
			}
		}

	}

	public void update(int id, Task updateTask) {

		Set<Task> arrList = TaskList.listOfTasks;
		for (Task task : arrList) {
			Task taskArr = task;
			if (task == null) {
				continue;
			}

			if (updateTask.getId() == id) {
//				task.setActive(updateTask.get());
				task.setTaskName(updateTask.getTaskName());
				task.setDueDate(updateTask.getDueDate());

				break;

			}

		}

	}

	public void delete(int taskId) {
		Set<Task> arrList = TaskList.listOfTasks;
		for (Task task : arrList) {
			Task taskArr = task;
			if (task == null) {
				continue;
			}

			if (task.getId() == taskId) {
				task.setActive(false);
				break;
			}
		}
	}

	public Task findById(int taskId) {
		Set<Task> arrList = TaskList.listOfTasks;
		Task taskMatch = null;

		for (Task task : arrList) {
			Task taskArr = task;
			if (task == null) {
				continue;
			}
			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}

		System.out.println("kl" + taskMatch);
		return taskMatch;
	}

	@Override
	public void create(User newUser) {
		// TODO Auto-generated method stub

	}

}
