package in.boomibalan.fertagriboomi.service;

import in.boomibalan.fertagriboomi.dao.TaskDAO;

import in.boomibalan.fertagriboomi.model.Task;

public class TaskService {
	
	public Task[] getAll() {

		TaskDAO userDao = new TaskDAO();

		Task[] taskList = userDao.findAll();

		for (int i = 0; i < taskList.length; i++) {

			System.out.println(taskList[i]);

		}

		return taskList;
	}

	
	public void create(Task newTask){
		TaskDAO userDao = new TaskDAO();
		userDao.create(newTask);
      
	}
	
	public void update() {

		Task newTask2 = new Task();
		newTask2.setId(753);
		newTask2.setDueDate("14/09/2023");
		newTask2.setTaskName("Musiryl");
		newTask2.setActive(true);
		
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(753,newTask2);
		
	}
	
	public void delete() {
		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(753);
	}
	
	public void findById() {
		TaskDAO taskDao = new TaskDAO();
		taskDao.findById(753);
	}
	
	

}
