import { Ingrediente } from './ingrediente.model';
export class Lanche {

  constructor(public id: number, public nome: string, public valor: number, public ingredientes: Ingrediente[]) {}

  static fromJSON(obj: Object): Lanche {
    return new Lanche(obj['id'], obj['nome'], obj['valor'], Ingrediente.fromJSONArray(obj['ingredientes']));
  }

  static fromJSONArray(array: Array<Object>): Lanche[] {
    if (array) {
      return array.map(obj => new Lanche(obj['id'], obj['nome'], obj['valor'], Ingrediente.fromJSONArray(obj['ingredientes'])));
    }

    return null;
  }
}
