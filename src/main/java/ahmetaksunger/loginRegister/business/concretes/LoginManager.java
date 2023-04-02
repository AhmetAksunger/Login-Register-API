package ahmetaksunger.loginRegister.business.concretes;

import org.springframework.stereotype.Service;

import ahmetaksunger.loginRegister.business.abstracts.LoginService;
import ahmetaksunger.loginRegister.business.requests.LoginUserRequest;
import ahmetaksunger.loginRegister.core.utilities.exceptions.BusinessException;
import ahmetaksunger.loginRegister.core.utilities.passwordHasher.PasswordHasher;
import ahmetaksunger.loginRegister.dataAccess.abstracts.UserRepository;
import ahmetaksunger.loginRegister.entities.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginManager implements LoginService{

	private UserRepository userRepository;

	@Override
	public String login(LoginUserRequest loginUserRequest) {
		
		User user = userRepository.findByEmail(loginUserRequest.getEmail());
		
		if(user == null) {
			
			throw new BusinessException("Wrong email");
			
		}
		
		String hashedPassword = PasswordHasher.hashPassword(loginUserRequest.getPassword());
		
		if(hashedPassword.equals(user.getPassword())) {
			
			return "Logged in succesfully";
			
		}else {
			
			throw new BusinessException("Wrong password ");
		}
		
	}
	
	
	
	
}
