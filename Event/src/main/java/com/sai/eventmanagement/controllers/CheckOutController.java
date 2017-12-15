package com.sai.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sai.eventmanagement.controllers.exceptions.NotCheckedInException;
import com.sai.eventmanagement.entities.Participant;
import com.sai.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckOutController {
	
	@Autowired
	private ParticipantRepository participantRepository; 
	
	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
		
		Participant participant = participantRepository.findOne(id);
		if(participant.getCheckedIn()== false) {	
				throw new NotCheckedInException();
		}
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		
		return ResponseEntity.ok(assembler.toResource(participant));

		
	}

}
