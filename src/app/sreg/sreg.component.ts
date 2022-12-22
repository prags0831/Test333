import { Component, OnInit } from '@angular/core';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-sreg',
  templateUrl: './sreg.component.html',
  styleUrls: ['./sreg.component.css']
})
export class SregComponent implements OnInit {
seller!:Seller;
message!:String;
  constructor(private service:SellerService) { }

  ngOnInit(): void {
    this.seller=new Seller();
  }
  createSeller() {
    this.service.createSeller(this.seller)
    .subscribe(data => {
      this.message = data; // read message
      this.seller= new Seller(); // clear form
    }, error => {
      console.log(error);
    });
  }

}
