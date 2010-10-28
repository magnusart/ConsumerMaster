package com.magnusart.crm.model.e.embeddable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StartEndDateInfoEmbeddable implements
		Comparable<StartEndDateInfoEmbeddable> {

	@Column(nullable = false, name = "start_date")
	private Date startDate;

	@Column(nullable = true, name = "end_date")
	private Date endDate;

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Only compares if a period is before or after. Is the period overlapping
	 * then they are the same. {@inheritDoc}
	 */
	@Override
	public int compareTo(final StartEndDateInfoEmbeddable o) {
		assert ((o.startDate != null) && (startDate != null));

		// Open Ended date
		if (o.endDate == null) {
			if (startDate.before(o.startDate)) {
				return -1;
			} else if (startDate.after(startDate)) {
				return 1;
			}

		} // Closed date
		else {
			if (startDate.before(o.startDate)
					&& (endDate.before(o.endDate) || endDate.equals(endDate))) {
				return -1;
			} else if ((startDate.after(o.endDate) || startDate
					.equals(o.endDate)) && endDate.after(o.endDate)) {
				return 1;
			}
		}

		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StartEndDateInfoEmbeddable)) {
			return false;
		}
		final StartEndDateInfoEmbeddable other = (StartEndDateInfoEmbeddable) obj;
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "StartEndDateInfoEmbeddable [startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
