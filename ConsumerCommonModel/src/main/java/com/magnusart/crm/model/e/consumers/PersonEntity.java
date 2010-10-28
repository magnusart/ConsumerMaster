package com.magnusart.crm.model.e.consumers;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.magnusart.crm.model.e.ConsumerEntity;

/**
 * The Person type of Consumer
 * 
 * @author Magnus Andersson
 * @since 21 sep 2010
 */
@Entity
@DiscriminatorValue(ConsumerEntity.PERSON_TYPE)
@Table(name = "persons")
public class PersonEntity extends ConsumerEntity implements ConsumerInformation {

	/**
	 * Gender of a Person
	 * 
	 * @author Magnus Andersson
	 * @since 21 sep 2010
	 */
	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = true, name = "middle_name")
	private String middleName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = true)
	private int age;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	/** {@inheritDoc} */
	@Override
	public String getCanonicalName() {
		return firstName + " " + lastName;
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
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(final int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + age;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
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
		if (!(obj instanceof PersonEntity)) {
			return false;
		}
		final PersonEntity other = (PersonEntity) obj;
		if (age != other.age) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!middleName.equals(other.middleName)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "PersonEntity [firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", addresses=" + addresses
				+ ", relations=" + relations + "]";
	}

}
