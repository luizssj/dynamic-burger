import { Ingrediente } from './../_models/ingrediente.model';
import { Lanche } from './../_models/lanche.model';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from "rxjs/Rx";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class IngredienteService {

  constructor(private http: Http) { }

  getAll(): Observable<Ingrediente[]> {
    return this.http.get("ingredientes")
      .map((response: Response) => Ingrediente.fromJSONArray(response.json()))
      .catch((error: any) => Observable.throw(error.json()));
  }
}
