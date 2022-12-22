import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Seller } from './seller';
import { Bids } from './Bids';

@Injectable({
  providedIn: 'root'
})
export class SellerService {
  createBid(p: Bids) {
    throw new Error('Method not implemented.');
  }

  private basePath = 'http://localhost:8090/rest/seller';

    constructor(private http: HttpClient) { }


    getAllSellers(): Observable<Seller[]> {
      return this.http.get<Seller[]>(`${this.basePath}/all`);
    }
  
    deleteOneSeller(id: number): Observable<any> {
      return this.http.delete(`${this.basePath}/remove/${id}`, {responseType: 'text'});
    }
  
    createSeller(seller: Seller): Observable<any> {
      return this.http.post(`${this.basePath}/save`, seller, {responseType: 'text'});
    }
  
    
    getOneSeller(id: number): Observable<Seller> {
      return this.http.get<Seller>(`${this.basePath}/one/${id}`);
    }
  
    updateSeller(id: number, seller: Seller): Observable<any> {
      return this.http.put(`${this.basePath}/modify/${id}`, seller, {responseType : 'text'});
    }
  createBids(p:Bids):Observable<any>
  {
    return this.http.post(`${this.basePath}/save`, p, {responseType: 'text'});
  }
  
  getAllBids(): Observable<Bids[]> {
    return this.http.get<Bids[]>(`${this.basePath}/all`);
  }
  deleteOneBids(id: number): Observable<any> {
    return this.http.delete(`${this.basePath}/remove/${id}`, {responseType: 'text'});
  }
  
  updateBid(id: number, p: Bids): Observable<any> {
    return this.http.put(`${this.basePath}/modify/${id}`, p, {responseType : 'text'});
  }
  }