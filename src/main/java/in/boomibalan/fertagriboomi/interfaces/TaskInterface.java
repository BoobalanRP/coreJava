package in.boomibalan.fertagriboomi.interfaces;

import java.time.LocalDate;
import java.util.List;

import in.boomibalan.fertagriboomi.model.Task;

public interface TaskInterface extends Base<Task> {

	public abstract List<Task> findDueDate(LocalDate date);

}