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

}