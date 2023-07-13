import { Component, inject } from '@angular/core';
import { Auth, User, authState } from '@angular/fire/auth';
import { Subscription } from 'rxjs';
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {

  env = environment;
  private auth: Auth = inject(Auth);
  authState = authState(this.auth);
  authStateSubscription: Subscription;

  public appPages = [
    { title: 'Página Inicial', url: '/home', icon: 'home' },
    { title: 'Calendários', url: '/calendars', icon: 'calendar' },
    { title: 'Faça Contato', url: '/contacts', icon: 'chatbubbles' },
    { title: 'Sobre nós', url: '/about', icon: 'information-circle' },
    { title: 'Sua privacidade', url: '/policies', icon: 'document-lock' }
  ];
  public appUser = {
    logged: false,
    title: 'Login / Entrar',
    url: '/login',
    icon: 'log-in',
    avatar: ''
  }
  constructor() {
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

  ngOnDestroy() {
    // when manually subscribing to an observable remember to unsubscribe in ngOnDestroy
    this.authStateSubscription.unsubscribe();
  }

}