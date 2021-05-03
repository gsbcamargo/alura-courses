package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {
	
    private Conta[] referencias;
    private int posicaoLivre;

    public GuardadorDeContas() {
    	this.referencias = new Conta[10];
    	this.posicaoLivre = 0;
    }

	public void adiciona(Conta referencia) {
		this.referencias[this.posicaoLivre] = referencia;
		this.posicaoLivre++;
		
	}

	public int getQuantidadeElementos() {
		return this.posicaoLivre;
	}

	public Conta getReferencia(int posicao) {
		return this.referencias[posicao];
	}
	
	
	
	

}
