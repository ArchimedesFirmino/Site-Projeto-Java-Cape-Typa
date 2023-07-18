import { Component, inject, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { PreloadAllModules, Router, RouterModule, Routes } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { Auth, authState, User } from '@angular/fire/auth';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-view',
  templateUrl: './view.page.html',
  styleUrls: ['./view.page.scss'],
})
export class ViewPage implements OnInit {
  public articleId!: string;
  private activatedRoute = inject(ActivatedRoute);
  public article: any;
  public user: any;
  public articleTitle!: string;
  public comments: any;
  success: boolean = false;
  commentForm!: FormGroup;
  comment!: any;
  firstName: String = "";
  private authState = authState(this.auth);
  private authStateSubscription = new Subscription;
  validationMessages: any = {
    fb_name: {
      required: 'O nome é obrigatório.',
      minlength: 'O nome está muito curto.'
    },
    cm_comment: {
      required: 'A mensagem é obrigatória.',
      minlength: 'A mensagem está muito curta.'
    }
  }
  formErrors: any = {
    fb_name: '',
    cm_comment: ''
  }
  public appUser = {
    logged: false,
    title: 'Login / Entrar',
    url: '/login',
    icon: 'log-in',
    avatar: ''
  }

  constructor(private http: HttpClient, private router: Router, private auth: Auth = inject(Auth), private formBuilder: FormBuilder) {
    this.authStateSubscription = this.authState.subscribe((aUser: User | null) => {
      if (aUser !== null) {
        this.appUser = {
          logged: true,
          title: aUser.displayName + '',
          url: '/profile',
          icon: 'log-out',
          avatar: aUser.photoURL + ''
        }
      }
    })
   }

  ngOnInit() {
    this.createForm();
    this.success = false;
    this.articleId = this.activatedRoute.snapshot.paramMap.get('id') as string;
    //Pega as Artigos para Apresentar na View.
    this.http.get(environment.apiBaseURL + `/articles/${this.articleId}`).subscribe(
      (response: any) => {
        this.article = response[0]; // Atribua os dados ao array de artigos
        this.articleTitle = this.article.title;
        console.log(this.article)
        this.getArticleAuthor();
      },

    );
    
    this.authStateSubscription = this.authState.subscribe(
      (userData: User | null) => {
        if (userData) {
          this.commentForm.controls['fb_name'].setValue(userData.displayName);
        }
      }
    );

  }

  getArticleAuthor() {
    //Pega os usuarios para apresentar na View
    this.http.get(environment.apiBaseURL + `/users/${this.article.ar_author.us_id}`).subscribe(
      (responseUser) => {
        this.user = responseUser; // Atribua os dados ao array de artigos
      },
    );
  }

  getArticleComments() {
    this.http.get(environment.apiBaseURL + `/comments/${this.article.ar_id}`).subscribe(
      (responseComment) => {
        this.comments = responseComment;
      }
    )
  }
  createForm() {
    this.commentForm = this.formBuilder.group({
      fb_name: ['', [Validators.required, Validators.minLength(3)]],
      cm_comment: ['', [Validators.required, Validators.minLength(5)]]
    });
  }
  updateValidationMessages() {
    for (const field in this.formErrors) {
      if (Object.prototype.hasOwnProperty.call(this.formErrors, field)) {
        this.formErrors[field] = '';
        const control = this.commentForm.get(field);
        if (control && control.dirty && !control.valid) {
          const messages = this.validationMessages[field];
          for (const key in control.errors) {
            if (Object.prototype.hasOwnProperty.call(control.errors, key)) {
              this.formErrors[field] += messages[key] + ' ';
            }
          }
        }
      }
    }
  }

  sendComment() {
    if (this.commentForm.invalid) return;
    this.comment = this.commentForm.value;
    this.comment.cm_date = new Date();
    this.comment.cm_status = 'on';
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    this.http.post(environment.apiBaseURL + '/comments/', this.comment, httpOptions).subscribe((response) => {
      console.log('Response do contato enviado:', response);
      this.firstName = this.comment.fb_name.split(' ')[0];
      this.success = true;
    },
      (error) => {
        alert('Oooops!\n' + error.message);
      }
    );
    this.commentForm.reset();
  }

  reset() {
    this.success = false;
    return false;
  }

}
