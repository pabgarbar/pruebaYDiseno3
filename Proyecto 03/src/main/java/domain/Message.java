
package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Message extends DomainEntity {

	private Date			moment;
	private String			subject;
	private String			body;
	private Priority		priority;
	private List<String>	tags;

	private Actor			sender;
	private List<Actor>		receivers;


	public Message() {		//For Json purposes
		super();
	}

	@Past
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	@NotBlank
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@NotBlank
	public String getBody() {
		return this.body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	@NotNull
	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(final Priority priority) {
		this.priority = priority;
	}

	@Valid
	@ElementCollection(targetClass = String.class)
	public List<String> getTags() {
		return this.tags;
	}

	public void setTags(final List<String> tags) {
		this.tags = tags;
	}

	@NotNull
	@ManyToOne(optional = false)
	public Actor getSender() {
		return this.sender;
	}

	public void setSender(final Actor sender) {
		this.sender = sender;
	}

	@NotBlank
	@ManyToMany
	public List<Actor> getReceivers() {
		return this.receivers;
	}

	public void setReceivers(final List<Actor> receivers) {
		this.receivers = receivers;
	}

}
