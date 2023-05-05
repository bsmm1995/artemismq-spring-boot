package com.java.consumer.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.consumer.dto.EmailDTO;
import com.java.consumer.util.Mapper;
import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class Listener {
    @JmsListener(destination = "${queue.name}", containerFactory = "queueConnectionFactory")
    public void consume(Message data) throws JsonProcessingException {
        EmailDTO dto = Mapper.objectMapper().readValue(((ActiveMQTextMessage) data).getText(), EmailDTO.class);
        log.info("Message sent from queue: " + dto);
    }

    @JmsListener(destination = "${topic.name}", containerFactory = "topicConnectionFactory")
    public void consumeTopicOne(Message data) throws JsonProcessingException {
        EmailDTO dto = Mapper.objectMapper().readValue(((ActiveMQTextMessage) data).getText(), EmailDTO.class);
        log.info("Message sent from Topic1: " + dto);
    }

    @JmsListener(destination = "${topic.name}", containerFactory = "topicConnectionFactory")
    public void consumeTopicTwo(Message data) throws JsonProcessingException {
        EmailDTO dto = Mapper.objectMapper().readValue(((ActiveMQTextMessage) data).getText(), EmailDTO.class);
        log.info("Message sent from Topic2: " + dto);
    }
}
