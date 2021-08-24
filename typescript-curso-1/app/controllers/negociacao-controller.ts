import { domInjector } from "../decorators/dom-injector.js";
import { inspecionar } from "../decorators/inspecionar.js";
import { logarTempoDeExecucao } from "../decorators/logar-tempo-execucao.js";
import { DiasDaSemana } from "../enums/dias-da-semana.js";
import { Negociacao } from "../models/negociacao.js";
import { Negociacoes } from "../models/negociacoes.js";
import { NegociacoesService } from "../services/negociacoes-service.js";
import { imprimir } from "../utils/imprimir.js";
import { MensagemView } from "../views/mensagem-view.js";
import { NegociacoesView } from "../views/negociacoes-view.js";

export class NegociacaoController {
    @domInjector('#data')
    private inputData: HTMLInputElement;

    @domInjector('#quantidade')
    private inputQuantidade: HTMLInputElement;  

    @domInjector('#valor')
    private inputValor: HTMLInputElement;
    
    private negociacoes: Negociacoes = new Negociacoes();
    private negociacoesView = new NegociacoesView('#negociacoesView');
    private mensagemView = new MensagemView('#mensagemView');
    protected readonly SABADO = 6;
    protected readonly DOMINGO = 0;
    private negociacoesService = new NegociacoesService;

    constructor() {
        this.negociacoesView.update(this.negociacoes);
    }

    @inspecionar
    @logarTempoDeExecucao()
    public adicionar(): void {
        const negociacao = Negociacao.criaDe(
            this.inputData.value,
            this.inputQuantidade.value,
            this.inputValor.value
        );

        if (!this.isDiaUtil(negociacao.data)) {
            this.mensagemView
                .update('São aceitas apenas negociações em dias úteis.');
            return;
        } else {
            this.negociacoes.adicionar(negociacao);
            imprimir(negociacao, this.negociacoes);
            this.limparFormulario();
            this.atualizarView();
        }
    }

    public importarDados(): void {
        this.negociacoesService
            .obterNegociacoesDoDia()
            .then(negociacoesDeHoje => {
                return negociacoesDeHoje.filter(negociacaoDeHoje => {
                    return !this.negociacoes
                        .listar()
                        .some(negociacao => negociacao
                            .ehIgual(negociacaoDeHoje)
                        );
                })
            })
            .then(negociacoesDeHoje => {
                for (let negociacao of negociacoesDeHoje) {
                    this.negociacoes.adicionar(negociacao);
                }
                this.negociacoesView.update(this.negociacoes);
            });
    }

    private isDiaUtil(data: Date): boolean {
        return data.getDay() > DiasDaSemana.DOMINGO && data.getDay() < DiasDaSemana.SABADO;
    }

    private limparFormulario(): void {
        this.inputData.value = '';
        this.inputQuantidade.value = '';
        this.inputValor.value = '';
        this.inputData.focus();
    }

    private atualizarView(): void {
        this.negociacoesView.update(this.negociacoes);
        this.mensagemView.update('Negociação adicionada com sucesso!');
    }
}