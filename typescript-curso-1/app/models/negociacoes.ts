import { Negociacao } from "./negociacao.js";

export class Negociacoes {
    private negociacoes: Negociacao[] = [];


    public adiciona(negociacao: Negociacao) {
        this.negociacoes.push(negociacao);
    }

    public listar(): readonly Negociacao[] {
        // return [...this.negociacoes]; // put the list items into a new list so changes cannot be performed in the latter
        return this.negociacoes;
    }
}