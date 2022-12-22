import { Component, OnInit } from '@angular/core';
import { Seller } from '../seller';
import { Router } from '@angular/router';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-listsellers',
  templateUrl: './listsellers.component.html',
  styleUrls: ['./listsellers.component.css']
})
export class ListsellersComponent implements OnInit {
seller!:Seller[];
message!:String;
constructor(private service: SellerService,private router:Router) { }

ngOnInit(): void {
  this.getAllSellers();
}
getAllSellers() {
  return this.service.getAllSellers()
  .subscribe(
    data => {
      this.seller = data;
    }, error => {
      console.log(error);
    }
  );
}
deleteSeller(id: number) {
  if (confirm('Do you want to delete?')) {
    this.service.deleteOneSeller(id).subscribe(data => {
      this.message = data;
      this.getAllSellers();
    }, error => {
      console.log(error);
    });
  } else {
    this.message = '';
  }
}
editSeller(id: number) {
  this.router.navigate(['soperations', id]);
}

}

