package com.example.archigrid.Email;

public interface EmailSender {
    void sendEmail(EmailRequest request);
    void send(String to, String email);
}
