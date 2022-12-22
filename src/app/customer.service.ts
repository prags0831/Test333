import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomerModel } from './CustomerModel';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private basePath = 'http://localhost:8090/rest/cus';

    constructor(private http: HttpClient) { }


    getAllCustomers(): Observable<CustomerModel[]> {
      return this.http.get<CustomerModel[]>(`${this.basePath}/all`);
    }
  
    deleteOneCustomer(id: number): Observable<any> {
      return this.http.delete(`${this.basePath}/remove/${id}`, {responseType: 'text'});
    }
  
    createCustomer(cus: CustomerModel): Observable<any> {
      return this.http.post(`${this.basePath}/save`, cus, {responseType: 'text'});
    }
  
    
    getOneCustomer(id: number): Observable<CustomerModel> {
      return this.http.get<CustomerModel>(`${this.basePath}/one/${id}`);
    }
  
    updateCustomer(id: number, cus: CustomerModel): Observable<any> {
      return this.http.put(`${this.basePath}/modify/${id}`, cus, {responseType : 'text'});
    }
  
  }