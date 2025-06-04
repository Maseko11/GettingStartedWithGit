package com.example.archigrid.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service

public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailRequest request) {
        // Create HTML content
        String emailContent = String.format("""
            <html>
                <body>
                    <h2>New Contact Form Submission</h2>
                    <p><strong>Name:</strong> %s</p>
                    <p><strong>Email:</strong> %s</p>
                    <p><strong>Message:</strong></p>
                    <p>%s</p>
                </body>
            </html>
            """,
                request.getName(),
                request.getEmail(),
                request.getMessage()
        );

        send("aminmaseko1@gmail.com", emailContent);  // Your receiving email
    }

    @Override
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("New Contact Form Submission");
            helper.setFrom("aminmaseko1@gmail.com");  // Your verified email
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send Email");
        }
    }
}
