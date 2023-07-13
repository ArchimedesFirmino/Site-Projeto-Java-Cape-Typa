import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Página Inicial', url: '/home', icon: 'home' },
    { title: 'Calendários', url: '/calendars', icon: 'calendar' },
    { title: 'Contate-nos', url: '/contacts', icon: 'paper-plane' },
    { title: 'Sobre nós', url: '/about', icon: 'information-circle' },
  ];
  constructor() {}
}
