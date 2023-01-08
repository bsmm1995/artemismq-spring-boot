package com.java.publisher.service;

import com.java.publisher.dto.EmailDTO;

public interface EmailService {

    void sendMessageQueue(EmailDTO data);

    void sendMessageTopic(EmailDTO data);
}
