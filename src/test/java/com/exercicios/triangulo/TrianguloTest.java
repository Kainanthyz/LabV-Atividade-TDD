package com.exercicios.triangulo;


import com.exercicios.triangulo.Triangulo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrianguloTest {

    @Test
    void testEquilatero() {
        assertEquals("Equilátero", Triangulo.verificarTipo(3, 3, 3));
    }

    @Test
    void testIsosceles1() {
        assertEquals("Isósceles", Triangulo.verificarTipo(3, 3, 5));
    }

    @Test
    void testIsosceles2() {
        assertEquals("Isósceles", Triangulo.verificarTipo(3, 5, 3));
    }

    @Test
    void testIsosceles3() {
        assertEquals("Isósceles", Triangulo.verificarTipo(5, 3, 3));
    }

    @Test
    void testEscaleno() {
        assertEquals("Escaleno", Triangulo.verificarTipo(3, 4, 5));
    }

    @Test
    void testNaoTrianguloZero() {
        assertEquals("Não é um triângulo", Triangulo.verificarTipo(0, 3, 4));
    }

    @Test
    void testNaoTrianguloNegativo() {
        assertEquals("Não é um triângulo", Triangulo.verificarTipo(-1, 3, 4));
    }

    @Test
    void testSomaIgual1() {
        assertEquals("Não é um triângulo", Triangulo.verificarTipo(1, 2, 3));
    }

    @Test
    void testSomaIgual2() {
        assertEquals("Não é um triângulo", Triangulo.verificarTipo(2, 1, 3));
    }

    @Test
    void testSomaMenor() {
        assertEquals("Não é um triângulo", Triangulo.verificarTipo(1, 2, 4));
    }

    @Test
    void testTodosZero() {
        assertEquals("Não é um triângulo", Triangulo.verificarTipo(0, 0, 0));
    }
}