import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from '../../service/authorization.service';
import {Member} from '../../../_model/member';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUserData = new Member();
  constructor(private auth: AuthorizationService) { }
  ngOnInit(): void {
  }

  login(): void {
    this.auth.login(this.loginUserData).subscribe(
      res => {
        if ( res != null){
          console.log(res);
          localStorage.setItem('token', res.token);
        }
        // this.router.navigate(['/subject']);
      },
      error => {
        console.log(error);
      }
    );
  }

}
