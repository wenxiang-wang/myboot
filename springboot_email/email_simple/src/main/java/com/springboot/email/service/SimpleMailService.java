package com.springboot.email.service;

public interface SimpleMailService {

    /**
     * 文本邮件
     */
    void sendSimpleMail();

    /**
     * 带附件的邮件
     */
    void sendFileMail();

    void sendThymleafMail();
}
