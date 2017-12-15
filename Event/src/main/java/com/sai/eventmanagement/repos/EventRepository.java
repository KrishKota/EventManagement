package com.sai.eventmanagement.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.sai.eventmanagement.entities.Event;
import com.sai.eventmanagement.entities.projections.PartialEventProjection;

@RepositoryRestResource(excerptProjection=PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	List<Event>findByName(@Param("name") String name);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long id);
	
}
