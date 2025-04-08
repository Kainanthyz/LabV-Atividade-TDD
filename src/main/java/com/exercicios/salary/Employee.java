package com.exercicios.salary;

public class Employee {
    private String name;
    private String email;
    private double baseSalary;
    private Position position;

    public Employee(String name, String email, double baseSalary, Position position) {
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    // Getters
    public double getBaseSalary() { return baseSalary; }
    public Position getPosition() { return position; }
}