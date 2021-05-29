import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Member} from '../../_model/member';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {
  registerURL = 'http://localhost:8081/user/register';
  loginURL = 'http://localhost:8081/user/login';
  constructor(private http: HttpClient) { }
  register(member: Member): Observable<Member>{
    const body = JSON.stringify(member);
    const myHeaders = new HttpHeaders().set('Content-type', 'application/json');
    return this.http.post(this.registerURL, body, {headers: myHeaders}).pipe(
      map((data: any) => data)
    );
  }
  login(member: Member): Observable<Member>{
    const body = JSON.stringify(member);
    const myHeaders = new HttpHeaders().set('Content-type', 'application/json');
    return this.http.post(this.loginURL, body, {headers: myHeaders}).pipe(
      map((data: any) => data)
    );
  }
}
