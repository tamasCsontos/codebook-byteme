import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Router} from '@angular/router';



const headers_object = new HttpHeaders();
headers_object.append('Content-Type', 'application/json');
headers_object.append('Authorization', 'Basic ' + btoa('admin:admin'));



@Injectable({
  providedIn: 'root'
})

export class WorkplaceService {


  private baseUrl = 'http://localhost:8080/workplaces';

  constructor(private http: HttpClient, private router: Router) {
  }


  getWorkplace(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`, {headers: headers_object});
  }

  createWorkplace(user: Object): Observable<Object> {
    console.log('sdadsadsadsa');
    return this.http.post(`${this.baseUrl}` + `/create`, user, {headers: headers_object});
  }

  updateWorkplace(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value, {headers: headers_object});
  }

  deleteWorkplace(id: number): Observable<any> {
    console.log('sdadsadsadsa');

    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text', headers: headers_object});
  }

  getWorkplacesList(): Observable<any> {
    console.log('sdadsadsadsa');
    return this.http.get(`${this.baseUrl}`, {headers: headers_object});
  }


  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, {responseType: 'text', headers: headers_object});
  }

}
