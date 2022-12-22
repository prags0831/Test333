import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SelleroperationsComponent } from './selleroperations/selleroperations.component';
import { SregComponent } from './sreg/sreg.component';
import { ListsellersComponent } from './listsellers/listsellers.component';
import { CustomeroperationsComponent } from './customeroperations/customeroperations.component';
import { CregComponent } from './creg/creg.component';
import { ListcustomersComponent } from './listcustomers/listcustomers.component';
import { PlacebidsComponent } from './placebids/placebids.component';
import { ListbidsComponent } from './listbids/listbids.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [ 
  {path: 'slist', component: ListsellersComponent},
{path: 'sreg', component: SregComponent},
{path: 'soperations/:id', component: SelleroperationsComponent},
{path: '', redirectTo: 'home', pathMatch: 'full'},
{path: 'creg', component: CregComponent},
{path: 'clist', component: ListcustomersComponent},
{path: 'coperations/:id', component: CustomeroperationsComponent},
{path: 'productbids', component: PlacebidsComponent},
{path: 'blist', component: ListbidsComponent},
{path: 'home', component: HomeComponent},];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
