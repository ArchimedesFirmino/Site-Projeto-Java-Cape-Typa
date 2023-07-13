import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {


  articles: any;
  articlesView: any;
  env = environment;


  constructor(private http: HttpClient) {
    this.getAllArticles();
    this.getMostViewed(5);
  }

  ngOnInit(): void {}


    getAllArticles(){
      this.http.get(`${this.env.apiBaseURL}/articles`)
        .subscribe((response) => {
          console.log(this.articles);
          this.articles = response;
        },
          (error) => {
            console.log(error)
          }
        )
    }
    getMostViewed(limit: number) {
      console.log('foi');
      this.http.get(`${this.env.apiBaseURL}/articles/views/${limit}`)
        .subscribe((response1) => {
          console.log(response1);
          this.articlesView = response1;

        },
          (error) => {
            console.log(error);
          }
        )


    }

}
