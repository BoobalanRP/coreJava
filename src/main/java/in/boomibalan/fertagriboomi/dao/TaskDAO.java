package in.boomibalan.fertagriboomi.dao;

import java.sql.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

import in.boomibalan.fertagriboomi.interfaces.TaskInterface;
import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.util.ConnectionUtil;
import java.time.*;

public class TaskDAO implements TaskInterface {

	public Set<Task> findAll() {
		// Set<Task> taskList = TaskList.listOfTasks;
		// return taskList;
		Connection conn = null;
		PreparedStatement ps = null;
		Set<Task> taskArray = new HashSet<Task>();
		ResultSet rs = null;
		try {
			String query = "select * from tasks where is_active = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				java.sql.Date sqlDate = rs.getDate("duedate");
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				task.setDueDate(utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				task.setTaskName(rs.getString("task_name"));
				task.setActive(rs.getBoolean("is_active"));
				taskArray.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return taskArray;

	}

	@Override
	public void create(Task newTask) {
//		Set<Task> arrList = TaskList.listOfTasks;
//		for (Task task : arrList) {
//			Task taskArr = task;
//			if (taskArr == null) {
//				task = newList;
//				break;
//			}
//		}
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO tasks (duedate, task_name) VALUES (?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			Date sqlDate = Date.valueOf(newTask.getDueDate());
			ps.setDate(1, sqlDate);
			ps.setString(2, newTask.getTaskName());

			ps.executeUpdate();

			System.out.println("Task has been created succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps);
		}

	}

	public void update(int id, Task updateTask) {
//
//		Set<Task> arrList = TaskList.listOfTasks;
//		for (Task task : arrList) {
//			Task taskArr = task;
//			if (task == null) {
//				continue;
//			}
//
//			if (updateTask.getId() == id) {
////				task.setActive(updateTask.get());
//				task.setTaskName(updateTask.getTaskName());
//				task.setDueDate(updateTask.getDueDate());
//
//				break;
//
//			}
//
//		}

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET duedate=?, task_name=? WHERE is_active=1 AND id=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			Date sqlDate = Date.valueOf(updateTask.getDueDate());
			ps.setDate(1, sqlDate);
			ps.setString(2, updateTask.getTaskName());
			ps.setInt(3, id);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Task with ID " + id + " has been updated successfully.");
			} else {
				System.out.println("User with ID " + id + " not found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps);
		}

	}

	@Override
	public void delete(int id) throws RuntimeException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET is_active= false WHERE id=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			// ps.setBoolean(1, false);
			ps.setInt(1, id);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("User with ID " + id + " has been deactivated successfully.");
			} else {
				System.out.println("User with ID " + id + " not found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps);
		}
	}

	public Task findById(int taskId) {

//	Set<Task> arrList = TaskList.listOfTasks;
//	Task taskMatch = null;
//
//	for (Task task : arrList) {
//		Task taskArr = task;
//		if (task == null) {
//			continue;
//		}
//		if (task.getId() == taskId) {
//			taskMatch = task;
//			break;
//		}
//	}
//
//	System.out.println("kl" + taskMatch);
//	return taskMatch;

		Connection conn = null;
		PreparedStatement ps = null;
		Task task = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1 AND id=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, taskId);

			rs = ps.executeQuery();

			if (rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));

				// Convert java.sql.Date to LocalDate
				Date sqlDate = rs.getDate("duedate");
				LocalDate dueDate = sqlDate.toLocalDate();
				task.setDueDate(dueDate);

				task.setTaskName(rs.getString("task_name"));
				task.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return task;
	}

	@Override
	public List<Task> findDueDate(LocalDate date) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Task> taskList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1 AND duedate=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			// Convert LocalDate to java.sql.Date
			Date sqlDate = Date.valueOf(date);
			ps.setDate(1, sqlDate);

			rs = ps.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				Date sqlDate1 = rs.getDate("duedate");
				LocalDate dueDate = sqlDate1.toLocalDate();
				task.setDueDate(dueDate);
				task.setTaskName(rs.getString("task_name"));
				task.setActive(rs.getBoolean("is_active"));
				taskList.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return taskList;
	}

}
