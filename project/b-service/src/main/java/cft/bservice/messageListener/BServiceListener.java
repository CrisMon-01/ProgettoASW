package cft.bservice.messageListener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import cft.bservice.domain.BService;
import cft.bservice.domain.CService;

@Component
public class BServiceListener {


	@Value("${cft.kafka.channel.in}")
	private String channel;

	@Value("${cft.kafka.groupid}")
	private String groupId;

    @Autowired
    private BService consumerService;

    
	@KafkaListener(topics = "${cft.kafka.channel.in}", groupId = "${cft.kafka.groupid}")
    public void listen(ConsumerRecord<String, String> record) throws Exception {
        String message = record.value();
		consumerService.onMessage(message);
    }

}
