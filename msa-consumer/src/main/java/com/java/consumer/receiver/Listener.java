package com.java.consumer.receiver;

import com.java.consumer.dto.EmailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {
    @JmsListener(destination = "${queue.name}", containerFactory = "queueConnectionFactory")
    public void consume(EmailDTO data) {
        log.info("Received Message: " + data);
    }

    @JmsListener(destination = "${topic.name}", containerFactory = "queueConnectionFactory")
    public void consumeTopicOne(EmailDTO data) {
        log.info("Received Message Topic1: " + data);
    }

    @JmsListener(destination = "${topic.name}", containerFactory = "queueConnectionFactory")
    public void consumeTopicTwo(EmailDTO data) {
        log.info("Received Message Topic2: " + data);
    }
}
