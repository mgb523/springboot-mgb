import { Component } from '@angular/core';
import {Link} from "./model/link";
import {LinkService} from "./service/link.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(linkService: LinkService) {
  }

  // public onSubmit(): void {
  // }

  // public shortenLink(link: Link): Link {
  //
  // }
}
