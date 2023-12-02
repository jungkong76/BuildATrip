package com.example.buildatrip.mail.service;

public interface EmailService {

    String sendCertificationMail(String mem_id, String mem_name) throws Exception;
}
