import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { SignupService } from '../signup.service';
import { LanguageService } from '../language.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  UserprofileForm = this.fb.group({

    name: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(8)])],
    language: this.fb.group({
      id: [''],
      name: ['']
    })

  });
  error: boolean = false;
  issignedup = false;
  messege: any;
  errorMessage: any;
  condition = false;
  languageList: any;
  constructor(private fb: FormBuilder, private service: SignupService, private languageService: LanguageService) { }
  ngOnInit() {
    this.languageService.getLanguages().subscribe(
      data => {
        this.languageList = data;
      })
  }
  save() {
    console.log("testing");
    console.log(this.UserprofileForm.value)
    this.service.save(this.UserprofileForm.value).subscribe(
      data => {
        if(data.signupStatus){
          this.messege = data;
          this.issignedup = true;
          console.log(data);
        }
     

      },
      error => {
        this.error = true;
        this.errorMessage = error;
        console.log(this.error);
      },

    )
  }
  onSubmit() {
    console.log
    console.warn(this.UserprofileForm.value);
  }

}

