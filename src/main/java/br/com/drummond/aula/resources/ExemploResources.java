package br.com.drummond.aula.resources;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploResources {
	
	// vide https://spring.io/quickstart
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "alunos") String name) {
	return String.format("Olá %s!", name);
	}
	
	@RequestMapping(value = {"/hello2/{ra}", "/hello2"}, method = RequestMethod.GET)
	public String hello2(@PathVariable(value = "ra", required = false) Optional<Integer> ra,
			@RequestParam(value = "name", defaultValue = "alunos") String name) {
		
	if (!ra.isPresent())
		return String.format("Olá %s sem RA!", name);
	else
		return String.format("Olá %s com RA %s!", name, ra.get());
	}

}
