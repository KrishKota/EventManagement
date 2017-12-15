package com.sai.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sai.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
