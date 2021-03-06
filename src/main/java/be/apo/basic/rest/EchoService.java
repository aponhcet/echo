package be.apo.basic.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoService {
	
	public final static String ECHO_MAPPING = "/echo";

	@RequestMapping(ECHO_MAPPING)
	public String echo(@RequestParam(value = "name", defaultValue = "World") String message) {
		return message;
	}
}
