import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { environment } from 'src/environments/environment';
import { redirectUnauthorizedTo, redirectLoggedInTo, AuthGuard } from '@angular/fire/auth-guard';

const toLogin = () => redirectUnauthorizedTo(['/login']);
const toHome = () => redirectLoggedInTo(['/home']);
const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'folder/:id',
    loadChildren: () => import('./folder/folder.module').then(m => m.FolderPageModule)
  },
  {
    path: 'home',
    title: `${environment.siteName} - Página Inicial`,
    loadChildren: () => import('./pages/home/home.module').then(m => m.HomePageModule)
  },
  {
    path: 'about',
    title: `${environment.siteName} - Sobre Nós`,
    loadChildren: () => import('./pages/about/about.module').then(m => m.AboutPageModule)
  },
  {
    path: 'view/:id',
    loadChildren: () => import('./pages/view/view.module').then(m => m.ViewPageModule)
  },
  {
    path: 'calendars',
    title: `${environment.siteName} - Calendários`,
    loadChildren: () => import('./pages/calendars/calendars.module').then(m => m.CalendarsPageModule)
  },
  {
    path: 'login',
    title: `${environment.siteName} - Login/ Entrar`,
    loadChildren: () => import('./users/login/login.module').then(m => m.LoginPageModule),
    canActivate: [AuthGuard],
    data: { authGuardPipe: toHome}
  },
  {
    path: 'logout',
    title: `${environment.siteName} - Logout/ Sair`,
    loadChildren: () => import('./users/logout/logout.module').then(m => m.LogoutPageModule)
  },
  {
    path: 'profile',
    title: `${environment.siteName} - Perfil do Usuário`,
    loadChildren: () => import('./users/profile/profile.module').then(m => m.ProfilePageModule),
    canActivate: [AuthGuard],
    data: { authGuardPipe: toLogin}
  },
  {
    path: 'contacts',
    title: `${environment.siteName} - Faça Contato`,
    loadChildren: () => import('./pages/contacts/contacts.module').then(m => m.ContactsPageModule)
  },
  {
    path: 'e404',
    title: `${environment.siteName} - Erro 404`,
    loadChildren: () => import('./pages/e404/e404.module').then(m => m.E404PageModule)
  }, {
    path: 'search/:query',
    title: `${environment.siteName} - Resultado`,
    loadChildren: () => import('./pages/search/search.module').then(m => m.SearchPageModule)
  },
  {
    path: 'policies',
    title: `${environment.siteName} - Sua Privacidade`,
    loadChildren: () => import('./pages/policies/policies.module').then(m => m.PoliciesPageModule)
  }, {
    path: '**',
    redirectTo: 'e404',
    pathMatch: 'full'
  },




];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
