import { NegociacaoController } from "./controllers/negociacao-controller.js"; 
import { NegociacoesView } from "./views/negociacoes-view.js";

const controller = new NegociacaoController;

const form = document.querySelector('.form');
if (form) {
    form.addEventListener('submit', event => {
        event.preventDefault();
        controller.adicionar();
    });
} else { 
    throw Error('Não foi possível inicializar a aplicação. Verifique se o form existe.')
}

const botaoImportar = document.querySelector('#botao-importar');
if (botaoImportar) {
    botaoImportar.addEventListener('click', () => {
        controller.importarDados();
    });
} else {
    throw Error('Botão importar não encontrado!');
}
