import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora2',
  templateUrl: './calculadora2.component.html',
  styleUrls: ['./calculadora2.component.css']
})
export class Calculadora2Component implements OnInit {

  // public displayValorActual: string;
  // public displayValorAnterior: string;
  // public tipoOperación = "0";
  // public valorActual = "";
  // public valorAnterior = "";
  // public num1: number;
  // public num2: number;
  // public signos = {  sumar: "+",
  // dividir: "%",
  // multiplicar: "x",
  // restar: "-",
  // };

  // class Calculadora {
  //   sumar(num1, num2) {
  //     return num1 + num2;
  //   }

  //   restar(num1, num2) {
  //     return num1 - num2;
  //   }

  //   dividir(num1, num2) {
  //     return num1 / num2;
  //   }

  //   multiplicar(num1, num2) {
  //     return num1 * num2;
  //   }
  // }

  //   constructor() {
  //     this.displayValorActual = "0";
  //     this.displayValorAnterior = "0";
  //     this.tipoOperación = "0";
  //     this.valorActual = "";
  //     this.valorAnterior = "";
  //     calculadora = new Calculadora;
  //     this.num1 = 0;
  //     this.num2 = 0;
  //     this.signos = {
  //       sumar: "+",
  //       dividir: "%",
  //       multiplicar: "x",
  //       restar: "-",
  //     };
  //   }



  //   borrar() {
  //     // agregamos la función en nuestro display con el onclick
  //     this.valorActual = this.valorActual.toString().slice(0, -1); // recortamos la última posición
  //     this.imprimirValores();
  //   }

  //   borrarTodo() {
  //     this.valorActual = "";
  //     this.valorAnterior = "";
  //     this.tipoOperación = "0";
  //     this.imprimirValores();
  //   }

  //   calculo(tipo: string ) {
  //     // el 'igual' es el value igual
  //     this.tipoOperación !== "igual" && this.calcular();
  //     this.tipoOperación = tipo;
  //     this.valorAnterior = this.valorActual || this.valorAnterior;
  //     this.valorActual = "";
  //     this.imprimirValores();
  //   }

  //   agregarNumero(numero: string) {
  //     // si numero es igual a punto o el valor actual incluye punto no devuelvas nada
  //     if ((numero === ".") && this.valorActual.includes(".")) return;
  //     this.valorActual = this.valorActual.toString() + numero.toString();
  //     this.imprimirValores();
  //   }

  //   imprimirValores() {
  //     this.displayValorActual = this.valorActual;
  //     this.displayValorAnterior =
  //       //mapeamos
  //       `${this.valorAnterior} ${this.signos[this.tipoOperación] || ""}`;
  //   }

  //   calcular() {
  //     // declaramos una constante y guardamos el valor to.String convertido a paseFloat en la const
  //     // como números para ser utilizados
  //     const valorAnterior = parseFloat(this.valorAnterior);
  //     const valorActual = parseFloat(this.valorActual);

  //     //isNaN(no es un número) no hacemos nada, hacemos un return vacío
  //     if (isNaN(valorActual) || isNaN(valorAnterior)) return;
  //     // si tienen valores entonces actualizamos el valor actual
  //     // this.valorActual = this.calculadora[this.tipoOperación](
  //     //   valorAnterior,
  //     //   valorActual
  //     // );
  //   }



  ngOnInit(): void {
  }

}
