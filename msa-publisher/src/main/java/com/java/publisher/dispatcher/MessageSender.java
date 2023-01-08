package com.java.publisher.dispatcher;

import com.java.publisher.dto.EmailDTO;

public interface MessageSender {
    void publishQueue(EmailDTO data);

    void publishTopic(EmailDTO data);
}
