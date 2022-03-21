// import {Display} from '../Web/Calculadora/Calculadora';

describe('Pruebas de la calculadora', ()=>{
        let display;
    describe('Calculadora', ()=> {
        let displayValorActual = {textContent:10}
        let displayValorAnterior = {textContent:2}
        beforeEach(() => {
            display = new Display(displayValorActual,displayValorAnterior);

          });
        describe('OK', () => {
            it('Cálculos', () => {
               // display = new Display(10,2);
                //expect(display(10+2)).toEqual(12)
                display.calculo('*')
                //expect(displayValorAnterior.textContent).toEqual(20)
                expect(display.tipoOperación).toEqual('*')
                expect(display.valorAnterior).toEqual(20)
                // expect(this.display.calculo(10-2)).toEqual(8)
                // expect(this.display.calculo(10/2)).toEqual(5)
            })
        });

//         describe("KO", () => {
//             it("Cálculos malos", () => {
//         expect(this.display.calculo("2+5")).not.toEqual(10);
//         expect(this.display.calculo("9*5")).not.toEqual(5);
//     });
//   });
});
});