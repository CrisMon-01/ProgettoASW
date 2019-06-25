package cft.aservice.messagePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cft.aservice.domain.AMessagePublisher;

@Component
public class AMessagePublisherImpl implements AMessagePublisher {

	@Value("${cft.kafka.channel.out}")
	private String channel;

	@Autowired
    private KafkaTemplate<String, String> template;

    @Override
    public void publish(String message) {
        template.send(channel, message);
    }

}
