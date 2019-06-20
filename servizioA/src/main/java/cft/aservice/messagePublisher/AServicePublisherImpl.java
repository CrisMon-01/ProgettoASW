package cft.aservice.messagePublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cft.aservice.domain.AServicePublisher;

@Component
public class AServicePublisherImpl implements AServicePublisher {

	//private Logger logger = Logger.getLogger(ServizioAPublisherImpl.class.toString());

	@Value("${cft.kafka.channel.out}")
	private String channel;

	@Autowired
    private KafkaTemplate<String, String> template;

    @Override
    public void publish(String message) {
        // logger.info("PUBLISHING MESSAGE: " + message + " ON CHANNEL: " + channel);
        template.send(channel, message);
        // template.flush();
    }

}
