package com.sai.eventmanagement.controllers.exceptions;


public class NotCheckedInException extends RuntimeException {
	
	@Override
	public String toString() {
		return " Participant have to check in";
	}
}
