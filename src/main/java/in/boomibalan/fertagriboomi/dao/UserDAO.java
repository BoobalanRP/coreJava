package in.boomibalan.fertagriboomi.dao;

import java.sql.*;
import java.util.*;

import in.boomibalan.fertagriboomi.interfaces.UserInterface;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.util.ConnectionUtil;

public class UserDAO implements UserInterface {

	@Override
	public Set<User> findAll() throws RuntimeException {
//		Set<User> userList = UserList.listOfUsers; // collecting data from UserList class.
//		return userList;
		Connection conn = null;
		PreparedStatement ps = null;
		Set<User> userArray = new HashSet<User>();
		ResultSet rs = null;

		try {
			String query = "select * from users where is_active = 1";

			// String query = "select * from users";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
				userArray.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return userArray;

	}

	@Override
	public void create(User newUser) throws RuntimeException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newUser.getFirstName());
			ps.setString(2, newUser.getLastName());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());
			ps.executeUpdate();

			System.out.println("User has been created succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps);
		}

	}

	@Override
	public void update(int id, User updatedUser) throws RuntimeException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET first_name=?, last_name=? WHERE is_active=1 AND id=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, updatedUser.getFirstName());
			ps.setString(2, updatedUser.getLastName());
			ps.setInt(3, id);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("User with ID " + id + " has been updated successfully.");
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
			String query = "UPDATE users SET is_active=? WHERE id=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setBoolean(1, false); // Deactivate the user by setting is_active to false
			ps.setInt(2, id);

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

	@Override
	public User findById(int userId) {
//		Set<User> userList = UserList.listOfUsers;
//		for (User user : userList) {
//			if (user != null && user.getId() == id) {
//				return user;
//			}
//		}
//		return null;

		Connection conn = null;
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * from users WHERE is_active = 1 AND id=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, userId);

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
//		Set<User> userList = UserList.listOfUsers;
//		for (User user : userList) {
//			if (user != null && user.getEmail() == email) {
//				return user;
//			}
//		}
//		return null;
		Connection conn = null;
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * from users WHERE is_active = 1 AND email=?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return user;
	}

	@Override
	public int count() {
		Set<User> userList = UserList.listOfUsers;
		int countOfUsers = 0;
		for (User user : userList) {
			if (user != null) {
				countOfUsers += 1;
			}
		}

		return countOfUsers;
	}

}
