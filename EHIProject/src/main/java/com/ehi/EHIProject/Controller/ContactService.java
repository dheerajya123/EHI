package com.ehi.EHIProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ehi.EHIProject.ContactNotFound;
import com.ehi.EHIProject.DAO.ContactDAO;
import com.ehi.EHIProject.Model.Contact;

public class ContactService {
  
	@Autowired
	ContactDAO dao;
	
	public Contact save(Contact contact)
	{
		return dao.save(contact);
	}
	
	public List<Contact> findAll()
	{
		return (List<Contact>) dao.findAll();
	}
	
	public boolean existById(Integer id)
	{
		return dao.existsById(id);
	}
	
	public void deleteById(Integer id)
	{
		System.out.println("delete id "+id);
		if(existById(id))
			dao.deleteById(id);
		else
		{
			System.out.println("delete id "+id);
			throw new ContactNotFound("Contact not available");
		}
	}
	
	public Contact updateContact(Contact contact)
	{
		if(existById(contact.getId()))
			return dao.save(contact);
		else
			throw new ContactNotFound("Contact not available");
	}
	
}
