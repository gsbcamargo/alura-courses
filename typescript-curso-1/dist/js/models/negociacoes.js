export class Negociacoes {
    constructor() {
        this.negociacoes = [];
    }
    adiciona(negociacao) {
        this.negociacoes.push(negociacao);
    }
    listar() {
        // return [...this.negociacoes]; // put the list items into a new list so changes cannot be performed in the latter
        return this.negociacoes;
    }
}
