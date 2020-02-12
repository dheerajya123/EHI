package com.ehi.EHIProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ContactNotFound extends RuntimeException{

	public ContactNotFound()
	{
		super();
	}
	
	public ContactNotFound(String mssg)
	{
		super(mssg);
	}
	
	public ContactNotFound(String mssg, Exception e)
	{
		super(mssg, e);
	}
}
