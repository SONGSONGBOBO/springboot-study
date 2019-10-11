package com.songbo.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;

/**
 * @ClassName MailService
 * @Description TODO
 * @Author songbo
 * @Date 19-10-11 下午4:56
 **/
@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;


    public boolean sendMail(String message, String title, String to){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(to);
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(message);
            mailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
      *@Description TODO 附件
      *@param
      *@return
    **/
    public boolean sendMailWithFile(String message, String title, String to, List<File> files){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(title);
            mimeMessageHelper.setText(message);
            String fileName = null;
            for (File file:files) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                mimeMessageHelper.addAttachment(fileName, file);
            }
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
