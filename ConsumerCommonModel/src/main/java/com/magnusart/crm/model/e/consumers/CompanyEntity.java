package com.magnusart.crm.model.e.consumers;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.magnusart.crm.model.e.ConsumerEntity;

/**
 * The Company type of Consumer
 * 
 * @author Magnus Andersson
 * @since 21 sep 2010
 */
@Entity
@DiscriminatorValue(ConsumerEntity.COMPANY_TYPE)
@Table(name = "companies")
public class CompanyEntity extends ConsumerEntity implements
		ConsumerInformation {
	/**
	 * Size of the company
	 * 
	 * @author Magnus Andersson
	 * @since 21 sep 2010
	 */
	public enum CompanySize {
		SMALL(10), MEDIUM(100), LARGE(1000);
		private final int num;

		private CompanySize(final int num) {
			this.num = num;
		}

		/**
		 * @return the num
		 */
		public int getNum() {
			return num;
		}
	}

	@Column(nullable = false, name = "company_name")
	private String companyName;

	@Column(nullable = true, name = "no_of_employees")
	private int noOfEmployees;

	@OneToOne(targetEntity = PersonEntity.class, optional = false)
	@PrimaryKeyJoinColumn
	private long mainContactPersonId;

	/** {@inheritDoc} */
	@Override
	public String getCanonicalName() {
		return companyName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the noOfEmployees
	 */
	public long getNoOfEmployees() {
		return noOfEmployees;
	}

	/**
	 * @param noOfEmployees
	 *            the noOfEmployees to set
	 */
	public void setNoOfEmployees(final int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	/**
	 * 
	 * @return Size of the Company
	 */
	public CompanySize getCompanySize() {
		// Set Company size depending on number of employees
		if (noOfEmployees <= CompanySize.SMALL.getNum()) {
			return CompanySize.SMALL;
		} else if (noOfEmployees <= CompanySize.MEDIUM.getNum()) {
			return CompanySize.MEDIUM;
		} else {
			return CompanySize.LARGE;
		}
	}

	/**
	 * @return the mainContactPerson
	 */
	public long getMainContactPersonId() {
		return mainContactPersonId;
	}

	/**
	 * @param mainContactPerson
	 *            the mainContactPerson to set
	 */
	public void setMainContactPerson(final PersonEntity mainContactPerson) {
		this.mainContactPersonId = mainContactPerson.getId();
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "CompanyEntity [companyName=" + companyName + ", noOfEmployees="
				+ noOfEmployees + ", mainContactPersonId="
				+ mainContactPersonId + ", addresses=" + addresses
				+ ", relations=" + relations + "]";
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result
				+ (int) (mainContactPersonId ^ (mainContactPersonId >>> 32));
		result = prime * result + noOfEmployees;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CompanyEntity)) {
			return false;
		}
		final CompanyEntity other = (CompanyEntity) obj;
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (mainContactPersonId != other.mainContactPersonId) {
			return false;
		}
		if (noOfEmployees != other.noOfEmployees) {
			return false;
		}
		return true;
	}

}
