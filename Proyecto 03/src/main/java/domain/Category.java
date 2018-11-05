
package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Category extends DomainEntity {

	private List<Category>	subCategorys;
	private String			name;


	public Category() {		//Created for Json purposes
		super();
	}

	@Valid
	public List<Category> getSubCategorys() {
		return this.subCategorys;
	}

	public void setSubCategorys(final List<Category> subCategorys) {
		this.subCategorys = subCategorys;
	}

	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
