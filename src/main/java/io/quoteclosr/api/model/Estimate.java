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
@Table(name = "estimate")
public class Estimate implements Serializable {
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "system-uuid")
	@Column(insertable = false, updatable = false)
	@Id
	private UUID id;

	@Column
	@NotNull
	private String name;

	@Column
	private String description;

	@Column
	private java.sql.Timestamp startDate;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User owner;

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
		if (!(o instanceof Estimate)) {
			return false;
		}

		Estimate other = (Estimate) o;

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
