export class Ingrediente {

  constructor(public id: number, public nome: string, public valor: number) {}

  static fromJSONArray(array: Array<Object>): Ingrediente[] {
    if (array) {
      return array.map(obj => new Ingrediente(obj['id'], obj['nome'], obj['valor']));
    }

    return null;
  }
}
