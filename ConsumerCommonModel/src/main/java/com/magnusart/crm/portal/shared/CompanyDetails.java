package com.magnusart.crm.portal.shared;

public class CompanyDetails extends ConsumerDetails {

	private static final long serialVersionUID = 1L;

	// Company details
	private String companyName;
	private String noOfEmployees;
	private String mainContactPersonId;

	/**
	 * Consumer of type Company.
	 */
	public CompanyDetails() {
		super(NO_ID);
	}

	/**
	 * Consumer of type Company.
	 * 
	 * @param companyName
	 *            The company name
	 * @param noOfEmployees
	 *            The number of employees
	 * @param mainContactPersonId
	 *            The main contact person
	 */
	public CompanyDetails(final String id, final String companyName,
			final String noOfEmployees, final String mainContactPersonId) {
		super(id);
		this.companyName = companyName;
		this.noOfEmployees = noOfEmployees;
		this.mainContactPersonId = mainContactPersonId;
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
	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	/**
	 * @param noOfEmployees
	 *            the noOfEmployees to set
	 */
	public void setNoOfEmployees(final String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	/**
	 * @return the mainContactPersonId
	 */
	public String getMainContactPersonId() {
		return mainContactPersonId;
	}

	/**
	 * @param mainContactPersonId
	 *            the mainContactPersonId to set
	 */
	public void setMainContactPersonId(final String mainContactPersonId) {
		this.mainContactPersonId = mainContactPersonId;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName
				+ ", noOfEmployees=" + noOfEmployees + ", mainContactPersonId="
				+ mainContactPersonId + ", getId()=" + getId() + "]";
	}

}
