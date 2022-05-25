package com.akhilesh.exception;

import java.util.Date;

public class ErrorDetails {

	private String message;
	private String details;
	private Date date;
	public ErrorDetails(String message, String details, Date date) {
		super();
		this.message = message;
		this.details = details;
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public Date getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + ", details=" + details + ", date=" + date + "]";
	}
	
}
