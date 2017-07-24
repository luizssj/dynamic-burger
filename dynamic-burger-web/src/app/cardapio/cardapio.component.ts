import { IngredienteService } from './../_services/ingrediente.service';
import { Ingrediente } from './../_models/ingrediente.model';
import { Lanche } from './../_models/lanche.model';
import { LancheService } from './../_services/lanche.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cardapio',
  templateUrl: './cardapio.component.html',
  styleUrls: ['./cardapio.component.css']
})
export class CardapioComponent implements OnInit {

  lanches: Lanche[];
  lancheSelecionado: Lanche;

  ingredientes: Ingrediente[];
  ingredienteSelecionado: Ingrediente;

  valorTotalIngredientes: number;

  constructor(private lancheService: LancheService, private ingredienteService: IngredienteService) {
  }

  ngOnInit() {
    this.lancheService.getAll().subscribe(
      lanches => {
        this.lanches = lanches;
      },
      err => {
        console.log("Error getAllLanches" + err);
      });

    this.ingredienteService.getAll().subscribe(
      ingredientes => {
        this.ingredientes = ingredientes;
      },
      err => {
        console.log("Error getAll Ingredientes" + err);
      });
  }

  getIngredientesString(ingredientes: Ingrediente[]): string {
    let nomeIngredientes: string = "";

    ingredientes.forEach((element, index) => {
      if (index > 0) nomeIngredientes += ", ";
      nomeIngredientes +=   element.nome;
    });

    return nomeIngredientes;
  }

  onLancheClicked(index: number) {
    this.lancheSelecionado = new Lanche(null, this.lanches[index].nome, this.lanches[index].valor, this.lanches[index].ingredientes.slice());
  }

  onAddIngrediente() {
    this.lancheSelecionado.ingredientes.push(this.ingredienteSelecionado);
  }

  onNovoLanche() {
    console.log("onnovoLanche");
    console.log(this.lancheSelecionado.id);
    this.lancheService.create(this.lancheSelecionado).subscribe(
      lanche => {
        this.lanches.push(lanche);
      },
      err => {
        console.log("Error createLanche" + err);
      });
  }
}
