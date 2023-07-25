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
	public void update(int id, User updatedUser) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == id) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setEmail(updatedUser.getEmail());
				user.setPassword(updatedUser.getPassword());
				user.setActive(true);
				break;
			}
		}
	}

	@Override
	public void delete(int id) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user != null && user.getId() == id) {
				user.setActive(false);
			}
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
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user != null && user.getEmail() == email) {
				return user;
			}
		}
		return null;
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
