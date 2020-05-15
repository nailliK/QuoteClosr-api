package io.quoteclosr.api.repository;

import io.quoteclosr.api.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, UUID> {
	Optional<Company> findById(UUID id);

	List<Company> findByDeleted(Boolean deleted);
}
