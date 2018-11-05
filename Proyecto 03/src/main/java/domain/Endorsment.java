
package domain;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Endorsment extends DomainEntity {

	private Date				moment;
	private Collection<String>	comments;
	private Endorser			writtenBy;
	private Endorser			writtenTo;


	@Past
	@NotNull
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	@Valid
	public Collection<String> getComments() {
		return this.comments;
	}

	public void setComments(final Set<String> comments) {
		this.comments = comments;
	}

	@NotNull
	public Endorser getWrittenBy() {
		return this.writtenBy;
	}

	public void setWrittenBy(final Endorser writtenBy) {
		this.writtenBy = writtenBy;
	}

	@NotNull
	public Endorser getWrittenTo() {
		return this.writtenTo;
	}

	public void setWrittenTo(final Endorser writtenTo) {
		this.writtenTo = writtenTo;
	}

}
