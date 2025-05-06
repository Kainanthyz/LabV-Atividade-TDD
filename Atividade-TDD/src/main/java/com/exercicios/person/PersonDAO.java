package com.exercicios.person;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonDAO {
    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();
        
        // Validação do nome
        if (p.getName() == null || p.getName().split(" ").length < 2) {
            errors.add("Nome deve ter pelo menos 2 partes");
        } else if (!p.getName().matches("[a-zA-ZÀ-ú ]+")) {
            errors.add("Nome deve conter apenas letras");
        }
        
        // Validação da idade
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("Idade deve estar entre 1 e 200");
        }
        
        // Validação de emails
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("Pessoa deve ter pelo menos um email");
        } else {
            Pattern emailPattern = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
            for (Email email : p.getEmails()) {
                if (!emailPattern.matcher(email.getName()).matches()) {
                    errors.add("Email inválido: " + email.getName());
                }
            }
        }
        
        return errors;
    }
    
    public void save(Person p) {
        // Implementação fictícia
    }
}