package it.unict.kafka.producer;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produce/")
public class ProducerController {
	
	@Autowired
	private Producer producer; 
	
	@Autowired
	private KafkaAdmin kafkaAdmin; 
	
	@RequestMapping("/{topic}")
	public void sendToVariableTopic(@PathVariable String topic, @RequestParam("text") String text) throws InterruptedException, ExecutionException {
		//AdminClient admin = AdminClient.create(kafkaAdmin.getConfig());
		//admin.createTopics(List.of(new NewTopic(topic,1, (short) 2))).all().get();
		System.out.println(topic);
        this.producer.produce(topic, text);
    }
	
}
