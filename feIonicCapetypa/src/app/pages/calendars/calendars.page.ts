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
  calendarsAut: any;


  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get(`${this.env.apiBaseURL}/calendars`)
      .subscribe((response) => {
        this.calendars = response;
        this.calendarsAut = this.calendars.ca_author;
        this.getCalendarsAuthor();
        console.log(this.calendars)
      })

  }
  getCalendarsAuthor() {
    //Pega os usuarios para apresentar na View
    this.http.get(`${this.env.apiBaseURL}/users/${this.calendarsAut.us_id}`).subscribe(
      (responseUser) => {
        this.user = responseUser; // Atribua os dados ao array de artigos
        console.log(this.user);
      },
      (error) => {
        console.error(error);
      }
    );
  }

}







