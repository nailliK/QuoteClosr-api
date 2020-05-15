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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "system-uuid")
	@Column(insertable = false, updatable = false)
	private UUID id;

	@Column
	@NotNull
	private String firstName;

	@Column
	@NotNull
	private String lastName;

	@Column(unique = true)
	@Email
	@NotBlank
	private String email;

	@Column
	@NotNull
	private String password;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToMany(fetch = FetchType.LAZY,
		cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
		})
	@JoinTable(name = "user_role",
		joinColumns = {@JoinColumn(name = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY,
		cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
		})
	@JoinTable(name = "user_team",
		joinColumns = {@JoinColumn(name = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "team_id")})
	private Set<Team> teams = new HashSet<>();

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
		if (!(o instanceof User)) {
			return false;
		}

		User other = (User) o;

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
