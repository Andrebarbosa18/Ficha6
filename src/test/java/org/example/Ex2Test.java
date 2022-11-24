package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex2Test {

    static Ex2 numero;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Inicio de testes");
    }

    @BeforeEach
    public static void setUp(){
        System.out.println("Instanciar um numero");
        numero = new Ex2();
    }

    @Nested
    class TestesParametros{
      @DisplayName("Ver se é primo")
      @ParameterizedTest
      @ValueSource(ints = {3,23,311,487,653,947})
        public void verSePrimo(int num){
            assertTrue(numero.isPrime(num));
      }
    }

    @DisplayName("Ver se é par")
    @ParameterizedTest
    @ValueSource(ints = {32,64,2,20,30,26})
    public void verSePar(int num){
        assertTrue(numero.isEven(num));
    }

    @DisplayName("Ver se é multiplo")
    @ParameterizedTest
    @ValueSource(ints = {23,46,115,184,207,230})
    public void verSeMultiplo(int num){
        assertTrue(numero.isMultiple(num,23));
    }
}
