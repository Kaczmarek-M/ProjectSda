package com.barterownia.service.interfaces;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
