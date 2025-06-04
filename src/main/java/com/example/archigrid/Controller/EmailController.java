package com.example.archigrid.Controller;

import com.example.archigrid.Email.EmailRequest;
import com.example.archigrid.Email.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/api/contact")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request);
            return ResponseEntity.ok().body("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to send email: " + e.getMessage());
        }
    }
}