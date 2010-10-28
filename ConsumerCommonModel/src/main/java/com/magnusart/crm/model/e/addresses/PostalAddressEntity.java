package com.magnusart.crm.model.e.addresses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.magnusart.crm.model.e.AddressEntity;

@Entity
@Table(name = "postal_addresses")
public class PostalAddressEntity extends AddressEntity {

	@Column(nullable = true)
	private String line1;

	@Column(nullable = true)
	private String line2;

	@Column(nullable = true)
	private String line3;

	@Column(nullable = true)
	private String line4;

	@Column(nullable = true)
	private String city;

	@Column(nullable = true, name = "gps_pos")
	private String gpsPos;

	@Column(nullable = true)
	private String country;

	@Column(nullable = true, name = "postal_code")
	private String postalCode;

	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * @param line1
	 *            the line1 to set
	 */
	public void setLine1(final String line1) {
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @param line2
	 *            the line2 to set
	 */
	public void setLine2(final String line2) {
		this.line2 = line2;
	}

	/**
	 * @return the line3
	 */
	public String getLine3() {
		return line3;
	}

	/**
	 * @param line3
	 *            the line3 to set
	 */
	public void setLine3(final String line3) {
		this.line3 = line3;
	}

	/**
	 * @return the line4
	 */
	public String getLine4() {
		return line4;
	}

	/**
	 * @param line4
	 *            the line4 to set
	 */
	public void setLine4(final String line4) {
		this.line4 = line4;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * @return the gpsPos
	 */
	public String getGpsPos() {
		return gpsPos;
	}

	/**
	 * @param gpsPos
	 *            the gpsPos to set
	 */
	public void setGpsPos(final String gpsPos) {
		this.gpsPos = gpsPos;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "PostalAddressEntity [line1=" + line1 + ", line2=" + line2
				+ ", line3=" + line3 + ", line4=" + line4 + ", city=" + city
				+ ", gpsPos=" + gpsPos + ", country=" + country
				+ ", postalCode=" + postalCode + "]";
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gpsPos == null) ? 0 : gpsPos.hashCode());
		result = prime * result + ((line1 == null) ? 0 : line1.hashCode());
		result = prime * result + ((line2 == null) ? 0 : line2.hashCode());
		result = prime * result + ((line3 == null) ? 0 : line3.hashCode());
		result = prime * result + ((line4 == null) ? 0 : line4.hashCode());
		result = prime * result
				+ ((postalCode == null) ? 0 : postalCode.hashCode());
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
		if (!(obj instanceof PostalAddressEntity)) {
			return false;
		}
		final PostalAddressEntity other = (PostalAddressEntity) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (gpsPos == null) {
			if (other.gpsPos != null) {
				return false;
			}
		} else if (!gpsPos.equals(other.gpsPos)) {
			return false;
		}
		if (line1 == null) {
			if (other.line1 != null) {
				return false;
			}
		} else if (!line1.equals(other.line1)) {
			return false;
		}
		if (line2 == null) {
			if (other.line2 != null) {
				return false;
			}
		} else if (!line2.equals(other.line2)) {
			return false;
		}
		if (line3 == null) {
			if (other.line3 != null) {
				return false;
			}
		} else if (!line3.equals(other.line3)) {
			return false;
		}
		if (line4 == null) {
			if (other.line4 != null) {
				return false;
			}
		} else if (!line4.equals(other.line4)) {
			return false;
		}
		if (postalCode == null) {
			if (other.postalCode != null) {
				return false;
			}
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		return true;
	}

}
