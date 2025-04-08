package com.exercicios.person;

import org.junit.jupiter.api.Test;
import com.exercicios.person.PersonDAO;
import com.exercicios.person.Person;
import com.exercicios.person.Email;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
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
        
        // Nome com apenas uma parte
        Person p1 = new Person(1, "João", 30, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors1 = dao.isValidToInclude(p1);
        assertFalse(errors1.isEmpty());
        assertTrue(errors1.contains("Nome deve ter pelo menos 2 partes"));
        
        // Nome com caracteres inválidos
        Person p2 = new Person(2, "João 123", 30, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors2 = dao.isValidToInclude(p2);
        assertFalse(errors2.isEmpty());
        assertTrue(errors2.contains("Nome deve conter apenas letras"));
        
        // Nome nulo
        Person p3 = new Person(3, null, 30, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors3 = dao.isValidToInclude(p3);
        assertFalse(errors3.isEmpty());
        assertTrue(errors3.contains("Nome deve ter pelo menos 2 partes"));
    }

    @Test
    void testAgeValidation() {
        PersonDAO dao = new PersonDAO();
        
        // Idade zero
        Person p1 = new Person(1, "João Silva", 0, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors1 = dao.isValidToInclude(p1);
        assertFalse(errors1.isEmpty());
        assertTrue(errors1.contains("Idade deve estar entre 1 e 200"));
        
        // Idade acima do máximo
        Person p2 = new Person(2, "João Silva", 201, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors2 = dao.isValidToInclude(p2);
        assertFalse(errors2.isEmpty());
        assertTrue(errors2.contains("Idade deve estar entre 1 e 200"));
        
        // Idade no limite inferior
        Person p3 = new Person(3, "João Silva", 1, Arrays.asList(new Email(1, "joao@email.com")));
        assertTrue(dao.isValidToInclude(p3).isEmpty());
        
        // Idade no limite superior
        Person p4 = new Person(4, "João Silva", 200, Arrays.asList(new Email(1, "joao@email.com")));
        assertTrue(dao.isValidToInclude(p4).isEmpty());
    }

    @Test
    void testEmailValidation() {
        PersonDAO dao = new PersonDAO();
        
        // Lista de emails vazia
        Person p1 = new Person(1, "João Silva", 30, Collections.emptyList());
        List<String> errors1 = dao.isValidToInclude(p1);
        assertFalse(errors1.isEmpty());
        assertTrue(errors1.contains("Pessoa deve ter pelo menos um email"));
        
        // Email inválido
        Person p2 = new Person(2, "João Silva", 30, 
            Arrays.asList(new Email(1, "email-invalido")));
        List<String> errors2 = dao.isValidToInclude(p2);
        assertFalse(errors2.isEmpty());
        assertTrue(errors2.contains("Email inválido: email-invalido"));
        
        // Múltiplos emails com um inválido
        Person p3 = new Person(3, "João Silva", 30, 
            Arrays.asList(
                new Email(1, "valido@email.com"),
                new Email(2, "invalido"),
                new Email(3, "outro.valido@email.com")
            ));
        List<String> errors3 = dao.isValidToInclude(p3);
        assertFalse(errors3.isEmpty());
        assertTrue(errors3.contains("Email inválido: invalido"));
        
        // Emails nulo
        Person p4 = new Person(4, "João Silva", 30, null);
        List<String> errors4 = dao.isValidToInclude(p4);
        assertFalse(errors4.isEmpty());
        assertTrue(errors4.contains("Pessoa deve ter pelo menos um email"));
        
        // Múltiplos emails válidos
        Person p5 = new Person(5, "João Silva", 30, 
            Arrays.asList(
                new Email(1, "email1@test.com"),
                new Email(2, "email2@test.com")
            ));
        assertTrue(dao.isValidToInclude(p5).isEmpty());
    }

    @Test
    void testSaveMethod() {
        PersonDAO dao = new PersonDAO();
        Person p = new Person(1, "João Silva", 30, 
            Arrays.asList(new Email(1, "joao@email.com")));
        
        // Teste que apenas verifica se o método executa sem exceções
        assertDoesNotThrow(() -> dao.save(p));
    }
}