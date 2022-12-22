import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';


import { CustomerService } from '../customer.service';
import { CustomerModel } from '../CustomerModel';

@Component({
  selector: 'app-listcustomers',
  templateUrl: './listcustomers.component.html',
  styleUrls: ['./listcustomers.component.css']
})
export class ListcustomersComponent implements OnInit {
  cus!:CustomerModel[];
  message!:String;
  constructor(private service: CustomerService,private router:Router) { }
  
  ngOnInit(): void {
    this.getAllCustomers();
  }
  getAllCustomers() {
    return this.service.getAllCustomers()
    .subscribe(
      data => {
        this.cus = data;
      }, error => {
        console.log(error);
      }
    );
  }
  deleteCustomer(id: number) {
    if (confirm('Do you want to delete?')) {
      this.service.deleteOneCustomer(id).subscribe(data => {
        this.message = data;
        this.getAllCustomers();
      }, error => {
        console.log(error);
      });
    } else {
      this.message = '';
    }
  }
  editCustomer(id: number) {
    this.router.navigate(['coperations', id]);
  }
  
  }
  