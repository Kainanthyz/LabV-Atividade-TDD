package com.exercicios.person;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;

    // Construtor, getters e setters
    public Person(int id, String name, int age, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails;
    }

    // Getters e Setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<Email> getEmails() { return emails; }
}