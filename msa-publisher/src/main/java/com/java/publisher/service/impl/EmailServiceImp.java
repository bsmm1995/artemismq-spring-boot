package com.java.publisher.service.impl;

import com.java.publisher.dispatcher.MessageSender;
import com.java.publisher.dto.EmailDTO;
import com.java.publisher.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImp implements EmailService {

    private final MessageSender messageSender;

    @Override
    public void sendMessageQueue(EmailDTO data) {
        messageSender.publishQueue(data);
    }

    @Override
    public void sendMessageTopic(EmailDTO data) {
        messageSender.publishTopic(data);
    }
}
