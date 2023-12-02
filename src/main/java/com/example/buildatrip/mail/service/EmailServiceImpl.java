package com.example.buildatrip.mail.service;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public static final String ePw = createKey();

    private MimeMessage createMessage(String mem_id, String mem_name)throws Exception{
        MimeMessage  message = javaMailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, mem_id);
        message.setSubject("[빌더트립] 회원가입 메일 인증");

        String msgg="";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h2>" + mem_name + "님, 안녕하세요.</h2>";
        msgg+= "<br>";
        msgg+= "<p>빌더 트립 회원가입을 위해 아래 코드를 복사해 입력해주세요.<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>이메일 인증 코드입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "인증코드 : <strong>"+ ePw+"</strong><div><br/>";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");
        message.setFrom(new InternetAddress("properties에 입력한 이메일","빌더트립"));

        return message;
    }

    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(3);

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    break;
            }
        }
        return key.toString();
    }

    @Override
    public String sendCertificationMail(String mem_id, String mem_name) throws Exception {
        MimeMessage message = createMessage(mem_id, mem_name);
        try{
            javaMailSender.send(message);
        }catch(MailException es){
            es.getStackTrace();
            throw new IllegalArgumentException();
        }
        return ePw;
    }
}
