package io.quoteclosr.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address implements Serializable {
	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "system-uuid")
	@Column(insertable = false, updatable = false)
	private UUID id;

	@Column(name = "street_1")
	@NotNull
	private String street1;

	@Column(name = "street_2")
	private String street2;

	@Column
	@NotNull
	private String city;

	@Column
	@NotNull
	private String state;

	@Column
	@NotNull
	private Long zip;

	@Column
	@NotNull
	private Long phone;

	@OneToOne(mappedBy = "address")
	private User user;

	@OneToOne(mappedBy = "address")
	private Company company;

	@JsonIgnore
	@Column(insertable = false)
	private Boolean deleted = false;

	@CreationTimestamp
	@Column(insertable = false, updatable = false)
	private java.sql.Timestamp createdAt;

	@UpdateTimestamp
	@Column(insertable = false, updatable = false)
	private java.sql.Timestamp updatedAt;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Address)) {
			return false;
		}

		Address other = (Address) o;

		// if the id is missing, return false
		if (id == null) {
			return false;
		}

		// equivalence by id
		return id.equals(other.getId());
	}

	@Override
	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		} else {
			return super.hashCode();
		}
	}
}
