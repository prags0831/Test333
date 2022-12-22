import { Component, OnInit } from '@angular/core';

import {ActivatedRoute,Router} from '@angular/router';

import { CustomerService } from '../customer.service';
import { CustomerModel } from '../CustomerModel';

@Component({
  selector: 'app-customeroperations',
  templateUrl: './customeroperations.component.html',
  styleUrls: ['./customeroperations.component.css']
})
export class CustomeroperationsComponent implements OnInit {
  id!:number;
  cus!:CustomerModel;
  constructor(private service:CustomerService,private router:Router,private activatedRoute:ActivatedRoute) { }
  
  ngOnInit(): void {
    this.id=this.activatedRoute.snapshot.params['id'];
    this.service.getOneCustomer(this.id)
    .subscribe (
      data=>{
        this.cus=data;
        console.log(this.cus);
      },error=>{
        console.log(error);
      }
    );
  }
  updateCustomer() {
    this.service.updateCustomer(this.id, this.cus)
    .subscribe( data => {
      console.log(data);
      this.router.navigate(['operations']);
    });
  }
  
  
  }
