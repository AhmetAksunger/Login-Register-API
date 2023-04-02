package ahmetaksunger.loginRegister.business.abstracts;

import ahmetaksunger.loginRegister.business.requests.RegisterUserRequest;

public interface RegisterService {

	String register(RegisterUserRequest registerUserRequest);
	
}
