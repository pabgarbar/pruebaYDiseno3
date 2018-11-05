
package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class HandyWorker extends Endorser {

	private String				make;
	private List<Application>	applications;
	private Collection<Finder>	finders;
	private List<Tutorial>		tutorials;
	private Curriculum			curriculum;


	@Valid
	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(final List<Application> applications) {
		this.applications = applications;
	}

	@Valid
	public Collection<Finder> getFinders() {
		return this.finders;
	}

	public void setFinders(final Collection<Finder> finders) {
		this.finders = finders;
	}

	@Valid
	public List<Tutorial> getTutorials() {
		return this.tutorials;
	}

	public void setTutorials(final List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	@Valid
	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(final Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	@NotBlank
	public String getMake() {
		return this.make;
	}

	public void setMake(final String make) {
		this.make = make;
	}

}
