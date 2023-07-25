package in.boomibalan.fertagriboomi.interfaces;

import java.util.*;

import in.boomibalan.fertagriboomi.model.Task;
import in.boomibalan.fertagriboomi.model.User;
import in.boomibalan.fertagriboomi.model.UserEntity;

public interface Base<T> {

	public abstract Set<T> findAll();

	public abstract void create(T newUser);

	public abstract void delete(int id);

	public abstract void update(int id, T newT);

	public abstract T findById(int id);

}
