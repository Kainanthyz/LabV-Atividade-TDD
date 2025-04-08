package com.exercicios.salary;

public class SalaryCalculator {
    public double calculate(Employee employee) {
        double discount;
        switch (employee.getPosition()) {
            case DESENVOLVEDOR:
                discount = employee.getBaseSalary() >= 3000 ? 0.20 : 0.10;
                break;
            case DBA:
            case TESTADOR:
                discount = employee.getBaseSalary() >= 2000 ? 0.25 : 0.15;
                break;
            case GERENTE:
                discount = employee.getBaseSalary() >= 5000 ? 0.30 : 0.20;
                break;
            default:
                discount = 0;
        }
        return employee.getBaseSalary() * (1 - discount);
    }
}