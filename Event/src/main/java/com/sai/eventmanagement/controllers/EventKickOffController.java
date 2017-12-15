package com.sai.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sai.eventmanagement.entities.Event;
import com.sai.eventmanagement.repos.EventRepository;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

	@Autowired
	private EventRepository eventRepository;

	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Event event = eventRepository.findOne(id);

		if (event == null) {
			throw new ResourceNotFoundException(); //check if event exist 
		}
		event.setStarted(true);     	  //if event exist set the started flag to true
		eventRepository.save(event);	//Response will be saved to data base

		return ResponseEntity.ok(event.getName() + "has Started");

	}

}
