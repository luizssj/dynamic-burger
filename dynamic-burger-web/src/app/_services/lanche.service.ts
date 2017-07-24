import { Lanche } from './../_models/lanche.model';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from "rxjs/Rx";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class LancheService {

  constructor(private http: Http) { }

  getAll(): Observable<Lanche[]> {
    return this.http.get("lanches")
      .map((response: Response) => Lanche.fromJSONArray(response.json()))
      .catch((error: any) => Observable.throw(error.json()));
  }

  create(lanche: Lanche): Observable<Lanche> {
    return this.http.post("lanches", lanche)
      .map((response: Response) => Lanche.fromJSON(response.json()))
      .catch((error: any) => Observable.throw(error.json()));
  }
}
