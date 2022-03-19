// import {Display} from '../Web/Calculadora/Calculadora';

describe('Pruebas de la calculadora', ()=>{
    describe('Calculadora', ()=> {
        beforeEach(() => {
            const display = new Display();
          });
        describe('OK', () => {
            it('Cálculos', () => {
                expect(display(10+2)).toEqual(12)
                // expect(this.display.calculo(10*2)).toEqual(20)
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