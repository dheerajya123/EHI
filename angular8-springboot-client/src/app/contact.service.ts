import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private baseUrl = 'http://localhost:8086/contact';

  constructor(private http: HttpClient) { }

  getContact(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createContact(contact: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, contact);
  }

  updateContact(contact: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update`, contact);
  }

  deleteContact(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete?Id=${id}`, { responseType: 'text' });
  }

  getContactsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/get`);
  }
}
