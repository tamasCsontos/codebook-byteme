import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

const headers_object = new HttpHeaders();
headers_object.append('Content-Type', 'application/json');
headers_object.append('Authorization', 'Basic ' + btoa('admin:admin'));



@Injectable({
  providedIn: 'root'
})

export class StudentService {


  private baseUrl = 'http://localhost:8080/students';

  constructor(private http: HttpClient, private router: Router) {
  }


  getStudent(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`, {headers: headers_object});
  }

  createStudent(user: Object): Observable<Object> {
    console.log('sdadsadsadsa');
    return this.http.post(`${this.baseUrl}` + `/create`, user, {headers: headers_object});
  }

  updateStudent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value, {headers: headers_object});
  }

  deleteStudent(id: number): Observable<any> {
    console.log('sdadsadsadsa');

    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text', headers: headers_object});
  }

  getStudentList(): Observable<any> {
    console.log('sdadsadsadsa');
    return this.http.get(`${this.baseUrl}`, {headers: headers_object});
  }


  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, {responseType: 'text', headers: headers_object});
  }

}
