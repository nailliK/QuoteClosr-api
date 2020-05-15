package io.quoteclosr.api.repository;

import io.quoteclosr.api.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, UUID> {
	Optional<Team> findById(UUID id);

	List<Team> findByDeleted(Boolean deleted);
}
