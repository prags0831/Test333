import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bids } from '../Bids';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-listbids',
  templateUrl: './listbids.component.html',
  styleUrls: ['./listbids.component.css']
})
export class ListbidsComponent implements OnInit {
  b!:Bids[];
  message!:String;
  constructor(private service: SellerService,private router:Router) { }
  
  ngOnInit(): void {
    this.getAllBids();
  }
  getAllBids() {
    return this.service.getAllBids()
    .subscribe(
      data => {
        this.b = data;
      }, error => {
        console.log(error);
      }
    );
  }
  deleteBid(id: number) {
    if (confirm('Do you want to delete?')) {
      this.service.deleteOneBids(id).subscribe(data => {
        this.message = data;
        this.getAllBids();
      }, error => {
        console.log(error);
      });
    } else {
      this.message = '';
    }
  }
  editBid(id: number) {
    this.router.navigate(['productbids', id]);
  }
  

}
