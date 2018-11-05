
package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
public class Referee extends Actor {

	private List<Report>	reports;


	@Valid
	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(final List<Report> reports) {
		this.reports = reports;
	}

}
