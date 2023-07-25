package in.boomibalan.fertagriboomi.model;

import java.time.LocalDate;

public class TaskEntity {
	int id;
	LocalDate dueDate;
	String taskName;
	boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate convertedDate) {
		this.dueDate = convertedDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Task : [id=" + id + ", dueDate=" + dueDate + ", taskName=" + taskName + ", isActive=" + isActive + "]";
	}
}
