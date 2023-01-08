package com.java.publisher.dispatcher;

import com.java.publisher.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageSenderImpl implements MessageSender {

    private final JmsTemplate jmsTemplate;

    @Value("${queue.name}")
    @NonFinal
    private String queueName;

    @Value("${topic.name}")
    @NonFinal
    private String topicName;


    @Override
    public void publishQueue(EmailDTO data) {
        jmsTemplate.convertAndSend(queueName, data);
        log.info("Message sent to queue: " + data);
    }

    @Override
    public void publishTopic(EmailDTO data) {
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(topicName, data);
        log.info("Message sent to topic: " + data);
    }
}
