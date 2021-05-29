import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrationComponent } from './pages/registration/registration.component';
import {AuthorizationService} from './service/authorization.service';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './pages/login/login.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    RegistrationComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
    RegistrationComponent,
    LoginComponent
  ],
  providers: [
    AuthorizationService,
    HttpClient,
    RouterModule
  ]
})
export class AuthorizationModule { }
