import { Component, OnInit } from '@angular/core';
import { Bids } from '../Bids';
import { SellerService } from '../seller.service';
//service
//class
@Component({
  selector: 'app-placebids',
  templateUrl: './placebids.component.html',
  styleUrls: ['./placebids.component.css']
})
export class PlacebidsComponent implements OnInit {

  p!:Bids;
  message!:String;
    constructor(private service:SellerService) { }
  
    ngOnInit(): void {
      this.p=new Bids();
    }
    createBids() {
      this.service.createBids(this.p)
      .subscribe(data => {
        this.message = data; // read message
        this.p= new Bids(); // clear form
      }, error => {
        console.log(error);
      });
    }
  
  }




