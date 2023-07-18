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
  env = environment;
  calendarsAut: any;


  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get(`${this.env.apiBaseURL}/calendars`)
      .subscribe((response) => {
        this.calendars = response;
        this.calendarsAut = this.calendars.ca_author;
      })

  }
}



