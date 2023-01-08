package com.java.publisher.controller;

import com.java.publisher.dto.EmailDTO;
import com.java.publisher.service.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
@RequiredArgsConstructor
@Tag(name = "Publish")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("queue")
    public ResponseEntity<EmailDTO> publishQueue(@RequestBody EmailDTO data) {
        emailService.sendMessageQueue(data);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/topic")
    public ResponseEntity<EmailDTO> publishTopic(@RequestBody EmailDTO data) {
        emailService.sendMessageTopic(data);
        return ResponseEntity.ok(data);
    }
}
