package io.quoteclosr.api.repository;

import io.quoteclosr.api.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
	Optional<User> findById(UUID id);

	List<User> findByDeleted(Boolean deleted);
}
