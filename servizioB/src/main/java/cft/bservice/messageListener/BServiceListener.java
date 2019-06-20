package cft.bservice.messageListener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import cft.bservice.domain.BService;

@Component
public class BServiceListener {

	//private Logger logger = Logger.getLogger(ServizioBListener.class.toString());

	@Value("${channelin}")
	private String channel;

	@Value("${groupid}")
	private String groupId;

    @Autowired
    private BService consumerService;

	//@KafkaListener(topics = "${cft.kafka.channel.in}", groupId="${cft.kafka.groupid}")
	@KafkaListener(topics = "${channelin}", groupId="${groupid}")
    public void listen(ConsumerRecord<String, String> record) throws Exception {
        // logger.info("MESSAGE LISTENER: " + record.toString());
        String message = record.value();
		consumerService.onMessage(message); 
    }

}
