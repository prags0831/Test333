import { Component, OnInit } from '@angular/core';


import { CustomerService } from '../customer.service';
import { CustomerModel } from '../CustomerModel';

@Component({
  selector: 'app-creg',
  templateUrl: './creg.component.html',
  styleUrls: ['./creg.component.css']
})
export class CregComponent implements OnInit {
cus!:CustomerModel;
message!:String;
  constructor(private service:CustomerService) { }

  ngOnInit(): void {
    this.cus=new CustomerModel();
  }
  createCustomer() {
    this.service.createCustomer(this.cus)
    .subscribe(data => {
      this.message = data; // read message
      this.cus= new CustomerModel(); // clear form
    }, error => {
      console.log(error);
    });
  }

}
