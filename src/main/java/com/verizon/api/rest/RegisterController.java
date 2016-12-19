package com.verizon.api.rest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {

	private static Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	// private TokenStorageService tokenStorageService;

	// @Autowired
	// public RegisterController(TokenStorageService tokenStorageService) {
	// this.tokenStorageService = tokenStorageService;
	// }

	// @PostMapping("/registration")
	// public ResponseEntity generateToken(@RequestBody Sender sender) {
	//// String token = TokenUtils.generateToken(sender);
	//// LOGGER.debug("Token generated: "+ token);
	//// token = tokenStorageService.save(sender.getCompany(), token);
	// return ResponseEntity.ok(token);
	// }

	@ExceptionHandler(Exception.class)
	public ResponseEntity exceptionhandler(Exception e) {
		LOGGER.error("Exception occured when generating token :", e);
		return new ResponseEntity(INTERNAL_SERVER_ERROR);
	}

}
