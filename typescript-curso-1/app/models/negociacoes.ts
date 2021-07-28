import { Negociacao } from "./negociacao.js";

export class Negociacoes {
    private negociacoes: Array<Negociacao> = [];


    adiciona(negociacao: Negociacao) {
        this.negociacoes.push(negociacao);
    }

    listar(): ReadonlyArray<Negociacao> {
        // return [...this.negociacoes]; // put the list items into a new list so changes cannot be performed in the latter
        return this.negociacoes;
    }
}