package in.boomibalan.fertagriboomi.dao;

import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.model.User;



public class TaskDAO {

	public Task[] findAll() {
		Task[] taskList = TaskList.listOfTasks;
		return taskList;
	}

	public void create(Task newList) {
		Task[] arr = TaskList.listOfTasks;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
			if (task == null) {
				arr[i] = newList;
				break;
			}
		}

	}
	
	public void update(int id, Task updateTask) {
		
		
		Task[] arr = TaskList.listOfTasks;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
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
		Task[] arr = TaskList.listOfTasks;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
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
		Task[] taskList = TaskList.listOfTasks;
		Task taskMatch = null;
		
	

		for (int i = 0; i < taskList.length; i++) {
			Task task = taskList[i];
			if (task == null) {
				continue;
			}
			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}
		
		System.out.println("kl"+taskMatch);
		return taskMatch;
	}
	
	
	

}
