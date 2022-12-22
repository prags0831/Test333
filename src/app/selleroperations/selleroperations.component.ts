import { Component, OnInit } from '@angular/core';
import { SellerService } from '../seller.service'; 
import {ActivatedRoute,Router} from '@angular/router';
import { Seller } from '../seller';
@Component({
  selector: 'app-selleroperations',
  templateUrl: './selleroperations.component.html',
  styleUrls: ['./selleroperations.component.css']
})
export class SelleroperationsComponent implements OnInit {
id!:number;
seller!:Seller;
constructor(private service:SellerService,private router:Router,private activatedRoute:ActivatedRoute) { }

ngOnInit(): void {
  this.id=this.activatedRoute.snapshot.params['id'];
  this.service.getOneSeller(this.id)
  .subscribe (
    data=>{
      this.seller=data;
      console.log(this.seller);
    },error=>{
      console.log(error);
    }
  );
}
updateSeller() {
  this.service.updateSeller(this.id, this.seller)
  .subscribe( data => {
    console.log(data);
    this.router.navigate(['operations']);
  });
}


}
