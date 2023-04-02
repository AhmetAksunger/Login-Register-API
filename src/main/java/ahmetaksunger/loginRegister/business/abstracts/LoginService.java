package ahmetaksunger.loginRegister.business.abstracts;

import ahmetaksunger.loginRegister.business.requests.LoginUserRequest;

public interface LoginService {

	String login(LoginUserRequest loginUserRequest);
	
	
}
