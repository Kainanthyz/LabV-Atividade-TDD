package com.exercicios.salary;

import com.exercicios.salary.Employee;
import com.exercicios.salary.Position;
import com.exercicios.salary.SalaryCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorTest {
    @Test
    void testDesenvolvedorSalarioAlto() {
        Employee emp = new Employee("João", "joao@email.com", 4000, Position.DESENVOLVEDOR);
        assertEquals(3200, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testDesenvolvedorSalarioBaixo() {
        Employee emp = new Employee("Maria", "maria@email.com", 2000, Position.DESENVOLVEDOR);
        assertEquals(1800, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testDbaSalarioAlto() {
        Employee emp = new Employee("Carlos", "carlos@email.com", 2500, Position.DBA);
        assertEquals(1875, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testTestadorSalarioBaixo() {
        Employee emp = new Employee("Ana", "ana@email.com", 1500, Position.TESTADOR);
        assertEquals(1275, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testGerenteSalarioAlto() {
        Employee emp = new Employee("Pedro", "pedro@email.com", 6000, Position.GERENTE);
        assertEquals(4200, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testGerenteSalarioBaixo() {
        Employee emp = new Employee("Lucia", "lucia@email.com", 4000, Position.GERENTE);
        assertEquals(3200, new SalaryCalculator().calculate(emp));
    }
}