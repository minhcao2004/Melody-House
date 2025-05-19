/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author admin
 */
public class resetService {
    private final int LIMIT_MINUS = 10;
    private final String from = "minhcaon2004@gmail.com";
    private final String password = "";
    
    public String generateToken(){
        return UUID.randomUUID().toString();
    }
    
    public LocalDateTime expireDateTime(){
        return LocalDateTime.now().plusMinutes(LIMIT_MINUS);
    }
    
    public boolean isExpireTime(LocalDateTime time){
        return LocalDateTime.now().isAfter(time);
    }
    
    public void sendEmail (String to, String link, String name){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttle.enable", "true");
    
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(form, password);
            }
        }
    }
}
