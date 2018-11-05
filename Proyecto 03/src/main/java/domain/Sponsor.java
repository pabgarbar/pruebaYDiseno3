
package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
public class Sponsor extends Actor {

	private List<Sponsorship>	Sponsorships;


	@Valid
	public List<Sponsorship> getSponsorships() {
		return this.Sponsorships;
	}

	public void setSponsorships(final List<Sponsorship> sponsorships) {
		this.Sponsorships = sponsorships;
	}

}
