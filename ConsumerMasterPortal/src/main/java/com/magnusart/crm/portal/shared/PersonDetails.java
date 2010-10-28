package com.magnusart.crm.portal.shared;

public class PersonDetails extends ConsumerDetails {
	private static final long serialVersionUID = 1L;

	// Person details
	private String firstName;
	private String middleName;
	private String lastName;
	private String age;

	/**
	 * Consumer of Person type.
	 */
	public PersonDetails() {
		super(NO_ID);
	}

	/**
	 * Consumer of Person type.
	 * 
	 * @param firstName
	 *            The first name
	 * @param middleName
	 *            The middle name
	 * @param lastName
	 *            The last name
	 * @param age
	 *            The age
	 */
	public PersonDetails(final String id, final String firstName,
			final String middleName, final String lastName, final String age) {

		super(id);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(final String age) {
		this.age = age;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "PersonDetails [firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age
				+ ", getId()=" + getId() + "]";
	}

}
