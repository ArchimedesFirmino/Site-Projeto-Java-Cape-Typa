import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { Auth, authState, User, } from '@angular/fire/auth';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-view',
  templateUrl: './view.page.html',
  styleUrls: ['./view.page.scss'],
})
export class ViewPage implements OnInit {
  // Variaveis de view (artigos)
  public articleId!: string;
  public article: any;
  public articleTitle!: string;
  // Variavel que armazena comentários
  public comments: any;
  // Variaveis para formulário de comentários
  success: boolean = false;
  commentForm!: FormGroup;
  comment!: any;
  firstName: String = '';
  // Conecta o Authentication
  public user: any;
  private authStateSubscription = new Subscription();

  validationMessages: any = { cm_comment: { required: "A mensagem é obrigatória" } }
  formErrors: any = { cm_comment: '' }
  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute,
    private auth: Auth = inject(Auth),
    private formBuilder: FormBuilder
  ) { }
  async isUserLoggedIn(): Promise<boolean> {
    const user = await this.auth.currentUser;
    return !!user;
  }

  ngOnInit() {
    this.createForm();
    this.success = false;

    this.articleId = this.activatedRoute.snapshot.paramMap.get('id') as string;

    //Pega as Artigos para Apresentar na View.
    this.http.get(environment.apiBaseURL + `/articles/${this.articleId}`).subscribe(
      (response: any) => {
        this.article = response[0];
        this.articleTitle = this.article.title;
        console.log(this.article);
        this.getArticleAuthor();
      }
    );
    // Quando o formulário de comentário for editado, executa 'updateValidationMessages()'.
    this.commentForm.valueChanges.subscribe(() => {
      this.updateValidationMessages();
    });
    // Se usuário está logado, preenche os campos.
    this.authStateSubscription = authState(this.auth).subscribe(
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
        this.user = responseUser;
      }
    )
  };
  getArticleComments() {
    //Pega os comentários do artigo selecionado.
    this.http.get(environment.apiBaseURL + `/comments/${this.article.ar_id}`).subscribe(
      (responseComment) => {
        this.comments = responseComment;
      }
    );
  }

  createForm() {
    this.commentForm = this.formBuilder.group({
      cm_comment: ['', [Validators.required, Validators.minLength(2)]]
    });
  }
  // Valida o preenchimento dos campos do formulário em tempo real.
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
    this.http.post(environment.apiBaseURL + '/comments/',this.comment, httpOptions).subscribe(
      (response) => {
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
  }
}