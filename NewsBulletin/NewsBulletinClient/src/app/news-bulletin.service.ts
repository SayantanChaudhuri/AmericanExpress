import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { NewsBulletinVO } from './news-bulletin.model';
import { Observable } from '../../node_modules/rxjs';


@Injectable({
  providedIn: 'root'
})
export class NewsBulletinService {

  constructor(private http: HttpClient) { }

  findAllNewsBulletins(): Observable<any> {
    return this.http.get('http://localhost:8080/newsBulletin');
  }
}
