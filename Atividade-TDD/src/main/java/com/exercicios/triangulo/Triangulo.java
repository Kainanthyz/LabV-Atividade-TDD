package com.exercicios.triangulo;

public class Triangulo {
    public static String verificarTipo(int a, int b, int c) {
        if (!ehTriangulo(a, b, c)) {
            return "Não é um triângulo";
        }
        
        if (a == b && b == c) {
            return "Equilátero";
        } else if (a == b || a == c || b == c) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
    
    private static boolean ehTriangulo(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}