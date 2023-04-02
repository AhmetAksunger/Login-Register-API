package ahmetaksunger.loginRegister.webApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetaksunger.loginRegister.business.abstracts.LoginService;
import ahmetaksunger.loginRegister.business.requests.LoginUserRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginController {

	private LoginService loginService;
	
	@GetMapping()
	public String login(LoginUserRequest loginUserRequest) {
		
		return loginService.login(loginUserRequest);
		
	}
	
}
