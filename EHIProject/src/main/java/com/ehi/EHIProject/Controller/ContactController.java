package com.ehi.EHIProject.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehi.EHIProject.ContactNotFound;
import com.ehi.EHIProject.DAO.ContactDAO;
import com.ehi.EHIProject.Model.Contact;

@RestController
@RequestMapping("/contact")
@CrossOrigin("http://localhost:4200")
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/get")
	public ResponseEntity<List<Contact>> getContacts() {
		// System.out.println("getting data");
		List<Contact> list = contactService.findAll();
		return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {

		Contact newContact = contactService.save(contact);
		return ResponseEntity.ok(newContact);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteContact(@RequestParam("Id") Integer id) throws ContactNotFound{
		/*
		 * System.out.println(id); if (!dao.existsById(id)) {
		 * System.out.println("id not present"); //throw new
		 * ContactNotFound("Contact not found exception"); return
		 * ResponseEntity.badRequest().build(); } else { dao.deleteById(id); return
		 * ResponseEntity.ok().build(); }
		 */
		contactService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) throws ContactNotFound{
		/*
		 * if(dao.existsById(contact.getId())) { Contact updateContact =
		 * dao.save(contact); return ResponseEntity.ok(updateContact); } else throw new
		 * ContactNotFound("Contact not found exception"); return
		 * ResponseEntity.ok().build();
		 */
		
		Contact newContact = contactService.updateContact(contact);
		return new ResponseEntity<Contact>(newContact, HttpStatus.OK);
	}
}
