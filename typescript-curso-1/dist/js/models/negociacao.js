export class Negociacao {
    constructor(_data, quantidade, valor) {
        this._data = _data;
        this.quantidade = quantidade;
        this.valor = valor;
    } // everyone has access to those attributes but no one can assign values to them
    get volume() {
        return this.quantidade * this.valor;
    }
    get data() {
        const data = new Date(this._data.getTime()); // creating a copy in order to avoid direct value change
        return this._data;
    }
}
