package com.java.consumer.config;

import com.java.consumer.dto.EmailDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

@Configuration
public class JmsConfig implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        EmailDTO employee = (EmailDTO) object;
        MapMessage message = session.createMapMessage();
        message.setString("id", employee.getId().toString());
        message.setString("header", employee.getHeader());
        message.setString("body", employee.getBody());
        message.setInt("code", employee.getCode());
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MapMessage map = (MapMessage) message;
        return new EmailDTO(UUID.fromString(map.getString("id")), map.getString("header"), map.getString("body"), map.getInt("code"));
    }
}