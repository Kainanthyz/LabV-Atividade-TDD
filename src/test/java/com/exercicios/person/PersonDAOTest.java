package com.exercicios.person;


import org.junit.jupiter.api.Test;
import com.exercicios.person.PersonDAO;
import com.exercicios.person.Person;
import com.exercicios.person.Email;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {
    @Test
    void testValidPerson() {
        PersonDAO dao = new PersonDAO();
        Person p = new Person(1, "João Silva", 30, 
            Arrays.asList(new Email(1, "joao@email.com")));
        
        assertTrue(dao.isValidToInclude(p).isEmpty());
    }

    @Test
    void testNameValidation() {
        PersonDAO dao = new PersonDAO();
        Person p1 = new Person(1, "João", 30, Arrays.asList(new Email(1, "joao@email.com")));
        assertFalse(dao.isValidToInclude(p1).isEmpty());
        
        Person p2 = new Person(2, "João 123", 30, Arrays.asList(new Email(1, "joao@email.com")));
        assertFalse(dao.isValidToInclude(p2).isEmpty());
    }

    @Test
    void testAgeValidation() {
        PersonDAO dao = new PersonDAO();
        Person p1 = new Person(1, "João Silva", 0, Arrays.asList(new Email(1, "joao@email.com")));
        assertFalse(dao.isValidToInclude(p1).isEmpty());
        
        Person p2 = new Person(2, "João Silva", 201, Arrays.asList(new Email(1, "joao@email.com")));
        assertFalse(dao.isValidToInclude(p2).isEmpty());
    }

    @Test
    void testEmailValidation() {
        PersonDAO dao = new PersonDAO();
        Person p1 = new Person(1, "João Silva", 30, Arrays.asList());
        assertFalse(dao.isValidToInclude(p1).isEmpty());
        
        Person p2 = new Person(2, "João Silva", 30, 
            Arrays.asList(new Email(1, "email-invalido")));
        assertFalse(dao.isValidToInclude(p2).isEmpty());
    }
}