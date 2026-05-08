package cl.usm.calculadoraspring.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    void calcularSumaOk() {
        CalculadoraService calculadoraService = new CalculadoraService();

        double res = calculadoraService.calcular("+", 1,2 );
        assertEquals(3, res);

    }

    @Test
    void calcularRestaFailed(){
        CalculadoraService calculadoraService = new CalculadoraService();

        double res = calculadoraService.calcular("-", 3, 1);
        assertNotEquals(5, res);

    }

    @Test
    void calcularRestaOk(){
        CalculadoraService calculadoraService = new CalculadoraService();

        double res = calculadoraService.calcular("-", 3, 1);
        assertEquals(2, res);

    }

    @Test
    void calcularMultiplicacionOk(){
        CalculadoraService calculadoraService = new CalculadoraService();

        double res = calculadoraService.calcular("*", 2, 3);
        assertEquals(6, res);

    }

    @Test
    void calcularDivisionOk(){
        CalculadoraService calculadoraService = new CalculadoraService();

        double res = calculadoraService.calcular("/", 4, 2);
        assertEquals(2, res);

    }

    @Test
    void CalcularDivisionNotOk(){

        CalculadoraService calculadoraService = new CalculadoraService();

        Exception ex = assertThrows(NumberFormatException.class, ()->{
            double res = calculadoraService.calcular("/", 2,0);
        });

        assertEquals("can't divide by zero", ex.getMessage());
    }

    @Test
    void CalcularOperationNotOk(){

        CalculadoraService calculadoraService = new CalculadoraService();

        Exception ex = assertThrows(NumberFormatException.class, ()->{
            double res = calculadoraService.calcular("$", 2,0);
        });

        assertEquals("Invalid operation", ex.getMessage());
    }
}