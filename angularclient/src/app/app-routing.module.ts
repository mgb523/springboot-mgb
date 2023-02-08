import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShortenLinkComponent } from './shorten-link/shorten-link.component';

const routes: Routes = [
  { path: 'users', component: ShortenLinkComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
