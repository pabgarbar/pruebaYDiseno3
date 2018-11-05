
package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
public class Customer extends Endorser {

	private List<FixUpTask>	fixUpTasks;


	@Valid
	public List<FixUpTask> getFixUpTasks() {
		return this.fixUpTasks;
	}

	public void setFixUpTasks(final List<FixUpTask> fixUpTasks) {
		this.fixUpTasks = fixUpTasks;
	}

}
