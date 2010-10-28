package com.magnusart.crm.model.e.addresses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.magnusart.crm.model.e.AddressEntity;

@Entity
@Table(name = "facebook_addresses")
public class FacebookAddressEntity extends AddressEntity {
	@Column(nullable = false, name = "facebook_url", unique = true)
	private String facebookUrl;

	@Column(nullable = true, name = "oauth_token")
	private String oAuthToken;

	/**
	 * @return the oAuthToken
	 */
	public String getoAuthToken() {
		return oAuthToken;
	}

	/**
	 * @param oAuthToken
	 *            the oAuthToken to set
	 */
	public void setoAuthToken(final String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}

	/**
	 * @return the facebookUrl
	 */
	public String getFacebookUrl() {
		return facebookUrl;
	}

	/**
	 * @param facebookUrl
	 *            the facebookUrl to set
	 */
	public void setFacebookUrl(final String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "FacebookAddressEntity [facebookUrl=" + facebookUrl
				+ ", oAuthToken=" + oAuthToken + ", getStartEndInfo()="
				+ getStartEndInfo() + "]";
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((facebookUrl == null) ? 0 : facebookUrl.hashCode());
		result = prime * result
				+ ((oAuthToken == null) ? 0 : oAuthToken.hashCode());
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
		if (!(obj instanceof FacebookAddressEntity)) {
			return false;
		}
		final FacebookAddressEntity other = (FacebookAddressEntity) obj;
		if (facebookUrl == null) {
			if (other.facebookUrl != null) {
				return false;
			}
		} else if (!facebookUrl.equals(other.facebookUrl)) {
			return false;
		}
		if (oAuthToken == null) {
			if (other.oAuthToken != null) {
				return false;
			}
		} else if (!oAuthToken.equals(other.oAuthToken)) {
			return false;
		}
		return true;
	}
}
