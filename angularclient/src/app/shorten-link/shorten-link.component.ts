import { Component, OnInit } from '@angular/core';
import {Link} from '../model/link';
import {LinkService} from '../service/link.service';
import {Clipboard} from '@angular/cdk/clipboard';

@Component({
  selector: 'app-shorten-link',
  templateUrl: './shorten-link.component.html',
  styleUrls: ['./shorten-link.component.css']
})
export class ShortenLinkComponent implements OnInit {

  title: string;

  link: Link = new Link();
  constructor(private linkService: LinkService) {
    this.title = 'Link Shortener';
  }

  ngOnInit() {

  }

  public onSubmit(): void {
    this.linkService.shorten(this.link).subscribe(
      data => {
        this.link.shortenedUrl = data;
      },
      err => console.log(err)
    );
  }

  public copyLink(): string {
    return this.link.shortenedUrl === undefined ? '' : this.link.shortenedUrl;
  }
}
