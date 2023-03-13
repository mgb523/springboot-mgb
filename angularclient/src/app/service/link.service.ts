import { Injectable } from '@angular/core';
import {catchError, Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Link} from '../model/link';

@Injectable({
  providedIn: 'root'
})
export class LinkService {

  private readonly shortenUrlBase: string;

  constructor(private http: HttpClient) {
     this.shortenUrlBase = 'http://linkshortener.us-east-1.elasticbeanstalk.com/short-link?rawUrl=';
  }

  public shorten(link: Link):  Observable<String> {
    const httpOptionsText = {
      headers: new HttpHeaders({
        Accept: "text/plain",
        "Content-Type": "text/plain"
      }),
      responseType: "text" as "json"
    };
    return this.http.get<String>(this.shortenUrlBase + link.url, httpOptionsText);
  }
}
