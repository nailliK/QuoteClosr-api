package io.quoteclosr.api.repository;

import io.quoteclosr.api.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, UUID> {
	Optional<Address> findById(UUID id);

	List<Address> findByDeleted(Boolean deleted);
}
