package com.ehi.EHIProject.DAO;

import org.springframework.data.repository.CrudRepository;

import com.ehi.EHIProject.Model.Contact;

public interface ContactDAO extends CrudRepository<Contact, Integer>{
	
	/* public Contact updateContact(Contact con); */
}
