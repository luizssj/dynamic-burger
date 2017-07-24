import { IngredienteService } from './_services/ingrediente.service';
import { LancheService } from './_services/lanche.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }    from '@angular/forms';
import { HttpModule, Http, XHRBackend, RequestOptions, JsonpModule } from '@angular/http';
import { HttpFactory } from "./_utils/http.factory";

import { AppComponent } from './app.component';
import { CardapioComponent } from './cardapio/cardapio.component';

@NgModule({
  declarations: [
    AppComponent,
    CardapioComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    {
      provide: Http,
      useFactory: HttpFactory,
      deps: [XHRBackend, RequestOptions]
    },
    LancheService,
    IngredienteService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
