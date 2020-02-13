import { Contact } from './../contact';
import { ContactService } from '../contact.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";

@Component({
  selector: 'app-create-contact',
  templateUrl: './create-contact.component.html',
  styleUrls: ['./create-contact.component.css']
})
export class CreateContactComponent implements OnInit {

  contacts: Observable<Contact[]>;
  contact: Contact;
  submitted = false;

  constructor(private contactService: ContactService,
    private router: Router) { }

  ngOnInit() {
    this.contact = new Contact();
    this.contacts = this.contactService.getContactsList();
  }

  newEmployee(): void {
    this.submitted = false;

  }

  save() {
    console.log(this.contact);
    this.contactService.createContact(this.contact)
      .subscribe(
        data => {
          console.log(data)
          this.contact = new Contact();
        }, error => console.log(error));
      this.updateTable();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  updateTable()
  {
    this.contacts = this.contactService.getContactsList();
  }

  deleteContact(id: number) {
    this.contactService.deleteContact(id)
      .subscribe(
        data => {
          console.log(data);
          this.updateTable();
        },
        error => console.log(error));
  }


  updateContact(contact: Contact){
    this.contact = contact;
    //this.router.navigate(['update', contact]);
  }

  numberOnly(event): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;

  }
}
