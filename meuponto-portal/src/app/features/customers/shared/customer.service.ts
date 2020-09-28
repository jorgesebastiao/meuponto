import { Injectable } from '@angular/core';
import {AuthHttp} from '../../../core/security/shared';
import {environment} from '../../../../environments/environment';
import {Page} from '../../../shared/models/page/page.model';
import {Observable} from 'rxjs';
import {HttpParams} from '@angular/common/http';
import { CustomerCreateCommand, CustomerUpdateComand, CustomerViewModel } from './customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  apiUrl: string;

  constructor(private http: AuthHttp) {
    this.apiUrl = `${environment.apiUrl}/customers`;
  }

  getAll(page?: Page, filter?: string): Observable<any> {
    let httpParans: HttpParams;
    if (page) {
      httpParans = new HttpParams().set('size', page.size.toString()).set('page', page.pageNumber.toString());
    }
    if (filter) {
      httpParans = httpParans.set('filter', filter);
    }

    return this.http.get(`${this.apiUrl}`, {
      params: httpParans,
      responseType: 'json'
    });
  }
  
  getById(customerId: number): Observable<CustomerViewModel> {
    return this.http.get(`${this.apiUrl}/${customerId}`);
  }

  post(customer: CustomerCreateCommand): Observable<any> {
    return this.http.post(this.apiUrl, JSON.stringify(customer));
  }

  put(customer: CustomerUpdateComand): Observable<any> {
    return this.http.put(this.apiUrl, JSON.stringify(customer));
  }
}
