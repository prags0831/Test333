import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SregComponent } from './sreg/sreg.component';
import { SelleroperationsComponent } from './selleroperations/selleroperations.component';
import { ListsellersComponent } from './listsellers/listsellers.component';
import { HttpClientModule } from '@angular/common/http';
import { CregComponent } from './creg/creg.component';

import { CustomeroperationsComponent } from './customeroperations/customeroperations.component';
import { ListcustomersComponent } from './listcustomers/listcustomers.component';
import { PlacebidsComponent } from './placebids/placebids.component';
import { ListbidsComponent } from './listbids/listbids.component';
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    SregComponent,
    SelleroperationsComponent,
    ListsellersComponent,
    CregComponent,
    CustomeroperationsComponent,
    ListcustomersComponent,
    PlacebidsComponent,
    ListbidsComponent,
    HomeComponent,
 
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
