import { Component, inject, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { PreloadAllModules, Router, RouterModule, Routes } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../environments/environment';

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


  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.articleId = this.activatedRoute.snapshot.paramMap.get('id') as string;
    console.log(this.articleId)

    //Pega as Artigos para Apresentar na View.
    this.http.get(environment.apiBaseURL + `/articles/${this.articleId}`).subscribe(
      (response: any) => {
        console.log(response)
        this.article = response[0]; // Atribua os dados ao array de artigos
        this.articleTitle = this.article.title;
        this.getArticleAuthor();
      },
      (error) => {
        console.error(error);
      }
    );


  }

  getArticleAuthor(){
     //Pega os usuarios para apresentar na View
     this.http.get(environment.apiBaseURL + `/users/${this.article.author}`).subscribe(
      (responseUser) => {
        console.log(responseUser)
        this.user = responseUser; // Atribua os dados ao array de artigos
      },
      (error) => {
        console.error(error);
      }
    );
  }


}
