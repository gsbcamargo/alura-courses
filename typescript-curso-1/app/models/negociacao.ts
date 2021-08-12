export class Negociacao {
    
    constructor(
        private _data: Date, 
        public readonly quantidade: number, 
        public readonly valor: number
        ) {} // everyone has access to those attributes but no one can assign values to them

    get volume() {
        return this.quantidade * this.valor;
    }

    get data(): Date {
        const data = new Date(this._data.getTime()); // creating a copy in order to avoid direct value change
        return this._data;
    }

    // todo método estático (sempre public) é um método que pode ser chamado diretamente na classe, não há necessidade de instanciação
    public static criaDe(dataString: string, quantidadeString: string, valorString: string): Negociacao { 
        const exp = /-/g;                                                                                  
        const date = new Date(dataString.replace(exp, ','));
        const quantidade = parseInt(quantidadeString);
        const valor = parseFloat(valorString);
        return new Negociacao(date, quantidade, valor);
    }

}