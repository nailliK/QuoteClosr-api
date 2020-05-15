package io.quoteclosr.api.repository;

import io.quoteclosr.api.model.Estimate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EstimateRepository extends PagingAndSortingRepository<Estimate, UUID> {
	Optional<Estimate> findById(UUID id);

	List<Estimate> findByDeleted(Boolean deleted);
}
