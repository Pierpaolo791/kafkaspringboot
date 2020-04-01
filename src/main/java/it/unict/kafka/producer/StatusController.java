package it.unict.kafka.producer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {
	
	@RequestMapping("/prova")
	public String prova() {
		return "prova";
	}
}
