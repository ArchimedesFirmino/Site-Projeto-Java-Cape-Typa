import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-calendars',
  templateUrl: './calendars.page.html',
  styleUrls: ['./calendars.page.scss'],
})
export class CalendarsPage implements OnInit {


  calendars: any;
  user: any;
  env = environment;
  authorArray: any;
  contaAuthorArray = 0;

  constructor(private http: HttpClient) {
    this.getAllCalendars();

  }

  ngOnInit(): void { }


  getAllCalendars() {
    this.http.get(`${this.env.apiBaseURL}/calendars`)
      .subscribe((response) => {
        this.calendars = response;
        console.log(this.calendars)
        this.contaAuthorArray++;
       this. authorArray[this.contaAuthorArray] = { authorId: this.calendars.author }
      })

  }
  getCalendarsAuthor() {
    //Pega os usuarios para apresentar na View
    this.http.get(environment.apiBaseURL + `/users/${this.calendars.author}`).subscribe(
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
