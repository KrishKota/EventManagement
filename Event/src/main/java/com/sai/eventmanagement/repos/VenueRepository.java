package com.sai.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sai.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
