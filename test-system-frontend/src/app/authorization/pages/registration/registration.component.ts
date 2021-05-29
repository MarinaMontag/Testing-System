import { Component, OnInit } from '@angular/core';
import {Member} from '../../../_model/member';
import {AuthorizationService} from '../../service/authorization.service';
import {Roles} from '../../../_model/roles';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registerUserData = new Member();
  roles = new Roles();
  constructor(private authService: AuthorizationService) { }
  ngOnInit(): void {
  }
  register(role: string): void{
    this.registerUserData.role = role;
    this.authService.register(this.registerUserData).subscribe(
      res => {
        localStorage.setItem('token', res.token);
      },
      error => {
        console.log(error);
      }
    );
  }

}
