package in.boomibalan.fertagriboomi.interfaces;

import java.util.Set;

import in.boomibalan.fertagriboomi.model.User;

public interface UserInterface extends Base<User> {
	public abstract User findByEmail(String email);

	public abstract int count();
}
