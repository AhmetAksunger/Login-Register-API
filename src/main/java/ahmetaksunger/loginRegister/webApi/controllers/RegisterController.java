package ahmetaksunger.loginRegister.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ahmetaksunger.loginRegister.business.abstracts.RegisterService;
import ahmetaksunger.loginRegister.business.requests.RegisterUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String register(@Valid RegisterUserRequest registerUserRequest) {
		
		return registerService.register(registerUserRequest);
		
	}
	
	
}
