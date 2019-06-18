package cft.servizioB.messageListener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import cft.servizioB.domain.ServizioB;

@Component
public class ServizioBListener {

	//private Logger logger = Logger.getLogger(ServizioBListener.class.toString());

	@Value("${cft.kafka.channel.in}")
	private String channel;

	@Value("${cft.kafka.groupid}")
	private String groupId;

    @Autowired
    private ServizioB consumerService;

	@KafkaListener(topics = "${cft.kafka.channel.in}", groupId="${cft.kafka.groupid}")
    public void listen(ConsumerRecord<String, String> record) throws Exception {
        // logger.info("MESSAGE LISTENER: " + record.toString());
        String message = record.value();
		consumerService.onMessage(message); 
    }

}
