package in.boomibalan.fertagriboomi.model;

public abstract class UserEntity implements Comparable<User> {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isActive = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + "]";
	}

	public int compareTo(User o) {
		if (this.id == o.getId()) {
			return 0;
		} else if (this.id > o.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

	public String fullName() {
		return firstName.concat(" ").concat(lastName);
	}
}
