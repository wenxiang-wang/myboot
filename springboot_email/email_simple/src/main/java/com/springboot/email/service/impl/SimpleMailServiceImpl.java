package com.springboot.email.service.impl;

import com.springboot.email.service.SimpleMailService;
import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.Date;

@Data
@Service("simpleMailService")
@ConfigurationProperties(prefix = "spring.mail")
public class SimpleMailServiceImpl implements SimpleMailService {


    private String username;

    private String nickname;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private TemplateEngine templateEngine;

    @Override
    public void sendSimpleMail() {

        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("测试邮件");
        // 设置邮件发送者，昵称+<邮箱地址>
        message.setFrom(nickname + '<' + username + '>');
        // 设置邮件接收者，可以有多个接收者，多个接受者参数需要数组形式
        message.setTo("1570679451@qq.com");
        // 设置邮件抄送人，可以有多个抄送人
        // message.setCc("12****32*qq.com");
        // 设置隐秘抄送人，可以有多个
        // message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("hello,do you one more");
        // 发送邮件
        javaMailSender.send(message);
        System.out.println("发送成功");
    }

    @Override
    public void sendFileMail() {
        try {
            MimeMessage mm = javaMailSender.createMimeMessage();
            MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
            mmh.setFrom(nickname + '<' + username + '>');
            mmh.setSubject("测试邮件-附件");
            mmh.setTo("1570679451@qq.com");
            mmh.setSentDate(new Date());
            mmh.setText("邮件发送成功");
            File file = new File("C:\\Users\\Wenxiang.Wang\\Pictures\\3-210604191124.jpg");
            mmh.addAttachment(file.getName(), file);
            javaMailSender.send(mm);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendThymleafMail() {
        try {
            MimeMessage mm = javaMailSender.createMimeMessage();
            MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
            mmh.setFrom(nickname + '<' + username + '>');
            mmh.setSubject("测试邮件-hymleaf-附件");
            mmh.setTo("1570679451@qq.com");
            mmh.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("username", username);
            String emailContext = templateEngine.process("index", context);
            mmh.setText(emailContext, true);
            File file = new File("C:\\Users\\Wenxiang.Wang\\Pictures\\3-210604191124.jpg");
            mmh.addAttachment(file.getName(), file);
            javaMailSender.send(mm);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
