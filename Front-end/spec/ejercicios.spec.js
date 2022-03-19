describe('Pruebas de los ejercicios', ()=>{
    describe('Ejercicio 1', ()=> {
        describe('OK', () => {
            it('Genera aleatorio', () => {
                let num = NumAleatorio(1,100); // metemos la función NumAleatorio
                expect(num).toBeGreaterThanOrEqual(1)
                expect(num).toBeLessThanOrEqual(100)
            })
        });
        describe ('KO', () =>{
            it('Falta parámetro')
            expect(()=>  NumAleatorio(1)).toThrow();
        });

    });
    describe('Ejercicio 2', () => {
        it('Pendiente')

    });
});

//     describe('Ejercicio 5', ()=> {
//         describe('NIF OK', () => {
//             ['12345678z', '23456787k', '123456789h'].forEach(caso => {
//             it(`NIF: ${caso}`, () => expect(esNIF(caso)).toBeTrue())
//         })
                
//         });
//         describe ('NIF KO', () =>{
//             ['12345678z', '23456787k', '123456789h'].forEach(caso => {
//             it(`NIF: ${caso}`, () => expect(esNIF(caso)).toBeFalse())
//         })
//     });
// });
// })
