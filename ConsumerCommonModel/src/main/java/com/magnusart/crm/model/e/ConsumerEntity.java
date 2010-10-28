package com.magnusart.crm.model.e;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.magnusart.crm.model.e.embeddable.BaseInfoEmbeddable;
import com.magnusart.crm.model.e.listeners.BaseInfoFiller;
import com.magnusart.crm.model.i.HasBaseInfo;

/**
 * The Consumer base entity
 * 
 * @author Magnus Andersson
 * @since 21 sep 2010
 */
@Entity
@EntityListeners(BaseInfoFiller.class)
@DiscriminatorColumn(name = "consumer_type")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "consumers")
public abstract class ConsumerEntity implements HasBaseInfo {

	/**
	 * Person type of Consumer
	 */
	public static final String PERSON_TYPE = "PERSON";

	/**
	 * Company type of Consumer
	 */
	public static final String COMPANY_TYPE = "COMPANY";

	@Id
	@SequenceGenerator(name = "consumer_seq", sequenceName = "consumer_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumer_seq")
	@Column(insertable = false, updatable = false)
	private long id;

	@Version
	private int version;

	@Embedded
	private final BaseInfoEmbeddable baseInfo = new BaseInfoEmbeddable();

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	@OneToMany(targetEntity = AddressEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "consumer_addresses_join", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"consumer_id_1_fk", "address_id_fk" }) }, joinColumns = { @JoinColumn(name = "consumer_id_1_fk", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "address_id_fk", nullable = false) })
	protected Collection<AddressEntity> addresses = new ArrayList<AddressEntity>();

	@OneToMany(targetEntity = RelationEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "consumer_relations_join", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"consumer_id_2_fk", "relation_id_fk" }) }, joinColumns = { @JoinColumn(name = "consumer_id_2_fk", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "relation_id_fk", nullable = false) })
	protected Collection<RelationEntity> relations = new ArrayList<RelationEntity>();

	/**
	 * @return the addresseIds
	 */
	public Collection<AddressEntity> getAddresses() {
		return addresses;
	}

	/**
	 * @return the relationIds
	 */
	public Collection<RelationEntity> getRelations() {
		return relations;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/** {@inheritDoc} */
	@Override
	public BaseInfoEmbeddable getBaseInfo() {
		return baseInfo;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "ConsumerEntity [id=" + id + ", version=" + version
				+ ", baseInfo=" + baseInfo + ", addresses=" + addresses
				+ ", relations=" + relations + "]";
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result
				+ ((relations == null) ? 0 : relations.hashCode());
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
		if (!(obj instanceof ConsumerEntity)) {
			return false;
		}
		final ConsumerEntity other = (ConsumerEntity) obj;
		if (addresses == null) {
			if (other.addresses != null) {
				return false;
			}
		} else if (!addresses.equals(other.addresses)) {
			return false;
		}
		if (relations == null) {
			if (other.relations != null) {
				return false;
			}
		} else if (!relations.equals(other.relations)) {
			return false;
		}
		return true;
	}

}
