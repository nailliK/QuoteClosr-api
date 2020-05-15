package io.quoteclosr.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role implements Serializable {
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "system-uuid")
	@Column(insertable = false, updatable = false)
	@Id
	private UUID id;

	@Column
	@NotNull
	private String name;

	@Fetch(value = FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		mappedBy = "roles")
	private Set<User> users = new HashSet<>();

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
		if (!(o instanceof Role)) {
			return false;
		}

		Role other = (Role) o;

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
