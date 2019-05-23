/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.valueprojetos.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andréia Leles
 */
@Service
public class EmailService {
    
    public void enviar(String nome, String emailMentor){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("andreiadamasio951@gmail.com", "ada123!@#"));
            email.setSSLOnConnect(true);

            email.setFrom("andreiadamasio951@gmail.com");
            email.setSubject("Confirmaçao para ser mentor no evento");
            email.setMsg("Olá " + nome + ". Você será nosso mentor.");
            email.addTo(emailMentor);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

   

    }
    
