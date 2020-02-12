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
    console.log("submit");
    if(this.contact.firstName!=""&&this.contact.lastName!=""&&this.contact.emailId!=""&&this.contact.phoneNumber.toString()!=""&&this.contact.status!="")
    {
    this.save();
    console.log("data");
    }
    else
    {
      console.log("please enter all the details");
    }
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

  onlyNumberKey(event) {
    return (event.charCode == 8 || event.charCode == 0) ? null : event.charCode >= 48 && event.charCode <= 57;
}
}
