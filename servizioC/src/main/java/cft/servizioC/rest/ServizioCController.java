package cft.servizioC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cft.servizioC.domain.ServizioC;

@RestController
public class ServizioCController {

	
	@Autowired 
	private ServizioC serviceC;
}
