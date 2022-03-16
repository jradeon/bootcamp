//FUNCIÓN Math.floor: redondea al número entero menor.
//FUNCIÓN Math.random: devuelve un número aleatorio mayor que 0 y menor que 1

// Ejercico 1

function NumAleatorio() {
  let num;
  num = Math.floor(Math.random() * 99) + 1;
  return num;
}

function NumerosAleatorios(min, max) {
  let num;
  num = Math.round(Math.random() * (max - min) + min); // match.round redondea
  return num;
}

// Ejercico 2
function AdivinarNumero() {
  alert("Adivina el número introducido");

  let numeroBuscado = NumAleatorio();
  let intentos = 10;
  for (let i = 1; i <= 10; i++) {
    let x = prompt("Ingrese numero: ");

    // if (typeof x != 'number') {
    //      prompt("Ingrese un dígito numérico: ");
    // }

    if (x != numeroBuscado) {
      intentos--;
      alert(
        "Has fallado, te quedan " + intentos + " intentos" + " " + numeroBuscado
      );
      if (x < numeroBuscado) {
        alert("El numero es mayor");
      }
      if (x > numeroBuscado) {
        alert("El numero es menor");
      }
    } else {
      alert("Has acertado");
      return "el numero es" + numeroBuscado;
    }
  }
}

// Ejercico 3
function DameArray(Nelementos, contiene) {
  let arr = [];
  // arr = ["Juan", "Antonio", "Pedro"]
  for (let i = 0; i < Nelementos; i++) {
    arr[i] = contiene;
  }

  return arr;
}

// Ejercicio 4
function esPrimo(numero) {
  for (let i = 2; i < numero; i++) {
    if (numero % i === 0) {
      return false;
    }
  }
  return true;
}

function damePrimos(cuantos) {
  let primos = [];
  for (let x = 2; x; x++) {
    if (esPrimo(x)) {
      primos.push(x); // con el push insertamos en el array
      if (primos.length >= cuantos) return primos;
    }
  }
}

// Ejercicio 5
//se le pide al usuario que introduzca su dni
function Dni(numero) {
  if (numero == null) return true;
  numero = numero.toUpperCase();
  if (!/^\d{1,8}[A-Za-z]$/.test(numero)) return false;
  return (
    "TRWAGMYFPDXBNJZSQVHLCKE".charAt(
      parseInt(numero.substring(0, numero.length - 1)) % 23
    ) == numero.charAt(numero.length - 1)
  );
}

// Ejercicio 6

function palindromeChecker(capicua) {
  const capicuaReversed = capicua.split("").reverse().join("");

  return capicuaReversed === capicua ? "es palindromo" : "no es palindromo";
}
//   console.log(palindromeChecker("oso")); // es palindromo
//   console.log(palindromeChecker("hola")); // no es palindromo
//   console.log(palindromeChecker("omo")); // es palindromo

/*Creamos la constante capicuaReversed, en la que guardaremos el string invertido.

.split('') lo separa en un array.

.reverse() revierte el arreglo.

.join('') Lo vuelve a convertir en string.

Por ultimo usando el operador ternario, 
indicamos que si ambas cadenas son iguales devuelva 'es palindromo', y si no 'no es palindromo'.*/



/*Objetos
Crear la función constructora del juego Adivina el Número.
Crear la clase del juego Adivina el Número */

//FUNCIÓN CONSTRUCTORA

function Juego(maxIntentos, valores) {
  var numeroBuscado;
  this.intentos;
  this.encontrado;
  this.mensaje;
  this.Inicializa = function () {
      numeroBuscado = aleatorio(1, valores);
      // debugger;
      console.debug(`Número generado: ${numeroBuscado}`)
      this.intentos = 0;
      this.encontrado = false;
      this.mensaje = 'Listo para jugar';
  }

  this.Inicializa();

  this.PruebaCon = function (numeroIntroducido) {
      if (this.intentos >= maxIntentos)
          throw new Error("Excedido el numero de intentos");
      if (!Number.isInteger(+numeroIntroducido))
          throw new Error("No es un numero correcto");
      this.intentos += 1;
      if (numeroBuscado == numeroIntroducido) {
          this.encontrado = true;
          this.mensaje = 'Bieeen!!! Acertaste.';
          return this.mensaje;
      }
      if (this.intentos >= maxIntentos) {
          this.mensaje = 'Upsss! Se acabaron los intentos, el número era el ' + numeroBuscado;
          return this.mensaje;
      }
      if (numeroBuscado > numeroIntroducido) {
          this.mensaje = 'Mi número es mayor.';
          return this.mensaje;
      }
      this.mensaje = 'Mi número es menor.';
      return this.mensaje;
  }
  this.DameMaxIntentos = function () { return maxIntentos; }
}

//FUNCIÓN CLASE
Juego.prototype.DameIntento = function () { return this.intentos + 1; }

class JuegoConClase {
  _maxIntentos;
  _valores;
  _numeroBuscado;
  constructor(maxIntentos, valores) {
      this._maxIntentos = maxIntentos;
      this._valores = valores;
      this.Inicializa();
  }
  Inicializa() {
      this._numeroBuscado = aleatorio(1, this._valores);
      this.intentos = 0;
      this.encontrado = false;
      this.mensaje = 'Listo para jugar';
  }
  PruebaCon(numeroIntroducido) {
      if (this.intentos >= this._maxIntentos)
          throw new Error("Excedido el numero de intentos");
      if (!Number.isInteger(+numeroIntroducido))
          throw new Error("No es un numero correcto");
      this.intentos += 1;
      if (this._numeroBuscado == numeroIntroducido) {
          this.encontrado = true;
          this.mensaje = 'Bieeen!!! Acertaste.';
          return this.mensaje;
      }
      if (this.intentos >= this._maxIntentos) {
          this.mensaje = 'Upsss! Se acabaron los intentos, el número era el ' + this._numeroBuscado;
          return this.mensaje;
      }
      if (this._numeroBuscado > numeroIntroducido) {
          this.mensaje = 'Mi número es mayor.';
          return this.mensaje;
      }
      this.mensaje = 'Mi número es menor.';
      return this.mensaje;
  }

  DameMaxIntentos() { return this._maxIntentos; }

  get maxIntentos() { return this._maxIntentos; }

  get intento() { return this.intentos + 1; }
}