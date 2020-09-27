import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from '../shared';

@Component({
  selector: 'mp-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private  authService: AuthService,
              private  router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.loginForm = this.formBuilder.group({
      email: this.formBuilder.control('', [Validators.required]),
      password: this.formBuilder.control('', [Validators.required])
    });
  }

  login() {
    this.authService.login(this.loginForm.get('email').value, this.loginForm.get('password').value)
      .then(() => {
        this.router.navigate(['']);
      }).catch(error => {

    });
  }
}
