
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Endorser extends Actor {

	private Score				score;
	private List<Endorsment>	endorsment;


	@Valid
	@OneToMany
	@ElementCollection(targetClass = Endorsment.class)
	public List<Endorsment> getEndorsment() {
		return this.endorsment;
	}

	public void setEndorsment(final List<Endorsment> endorsment) {
		this.endorsment = endorsment;
	}

	@NotNull
	public Score getScore() {
		return this.score;
	}

	public void setScore(final Score score) {
		this.score = score;
	}

}
