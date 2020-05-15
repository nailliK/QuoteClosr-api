package io.quoteclosr.api.repository;

import io.quoteclosr.api.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, UUID> {
	Optional<Role> findById(UUID id);

	List<Role> findByDeleted(Boolean deleted);
}
