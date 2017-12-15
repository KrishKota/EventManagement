package com.sai.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sai.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
