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
    void testDesenvolvedorSalarioLimite() {
        Employee emp = new Employee("Carlos", "carlos@email.com", 3000, Position.DESENVOLVEDOR);
        assertEquals(2400, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testDbaSalarioAlto() {
        Employee emp = new Employee("Ana", "ana@email.com", 2500, Position.DBA);
        assertEquals(1875, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testDbaSalarioBaixo() {
        Employee emp = new Employee("Pedro", "pedro@email.com", 1500, Position.DBA);
        assertEquals(1275, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testDbaSalarioLimite() {
        Employee emp = new Employee("Lucia", "lucia@email.com", 2000, Position.DBA);
        assertEquals(1500, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testTestadorSalarioAlto() {
        Employee emp = new Employee("Paulo", "paulo@email.com", 2500, Position.TESTADOR);
        assertEquals(1875, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testTestadorSalarioBaixo() {
        Employee emp = new Employee("Fernanda", "fernanda@email.com", 1500, Position.TESTADOR);
        assertEquals(1275, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testTestadorSalarioLimite() {
        Employee emp = new Employee("Ricardo", "ricardo@email.com", 2000, Position.TESTADOR);
        assertEquals(1500, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testGerenteSalarioAlto() {
        Employee emp = new Employee("Marcos", "marcos@email.com", 6000, Position.GERENTE);
        assertEquals(4200, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testGerenteSalarioBaixo() {
        Employee emp = new Employee("Juliana", "juliana@email.com", 4000, Position.GERENTE);
        assertEquals(3200, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testGerenteSalarioLimite() {
        Employee emp = new Employee("Roberto", "roberto@email.com", 5000, Position.GERENTE);
        assertEquals(3500, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testPosicaoInvalida() {
        Employee emp = new Employee("Invalido", "invalido@email.com", 1000, null);
        assertEquals(0, new SalaryCalculator().calculate(emp));
    }

    @Test
    void testEmployeeNulo() {
        assertEquals(0, new SalaryCalculator().calculate(null));
    }
}