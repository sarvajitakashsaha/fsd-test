import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private fb: FormBuilder, private loginService: LoginService, private service: AuthserviceService, private router: Router) { }

  ngOnInit() {
  }

  form = this.fb.group({
    email: ['', Validators.required],
    password: ['', Validators.required]
  });

  error: any;
  loggedIn = false;

  authenticate() {

    this.loginService.authenticate(this.form.value).subscribe(
      data => {
        console.log("authenticate")
        console.log(data)
        if (data.authenticated) {
          // this.service.login();
          this.loggedIn = true;
          this.service.setArticle(data.user.article);
          this.service.setStatus(data.user.status)
          this.service.setLogin(this.loggedIn);
          this.service.setData(data)
          this.service.setEmail(data.user.email);
          this.service.setRole(data.user.role.name);
          this.service.setLanguageCode(data.user.language.code);

          // console.log(data.user.language.name);
          console.log(data.user.language.code);
          this.router.navigate(['/article']);
        }
        if (data.user.role.id == 1) {

          this.router.navigate(['/search']);
        }
      },
      error => {
        this.error = error;
      });

    this.form.reset();
  }
  signup() {
    this.router.navigate(['/signup']);
  }
}
