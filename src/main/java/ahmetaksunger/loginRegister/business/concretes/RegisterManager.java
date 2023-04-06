package ahmetaksunger.loginRegister.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetaksunger.loginRegister.business.abstracts.ChangeLogService;
import ahmetaksunger.loginRegister.business.abstracts.RegisterService;
import ahmetaksunger.loginRegister.business.requests.RegisterUserRequest;
import ahmetaksunger.loginRegister.business.rules.UserBusinessRules;
import ahmetaksunger.loginRegister.core.utilities.mappers.ModelMapperService;
import ahmetaksunger.loginRegister.core.utilities.passwordHasher.PasswordHasher;
import ahmetaksunger.loginRegister.dataAccess.abstracts.UserRepository;
import ahmetaksunger.loginRegister.entities.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterManager implements RegisterService {
	
	@Autowired
	private ChangeLogService changeLogService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapperService modelMapperService;
	
	@Autowired
	private UserBusinessRules userBusinessRules;
	
	@Override
	public String register(RegisterUserRequest registerUserRequest) {
		
		userBusinessRules.confirmPassword(registerUserRequest.getPassword(), registerUserRequest.getConfirmPassword());
		userBusinessRules.checkIfEmailExists(registerUserRequest.getEmail());
		userBusinessRules.isAgeValid(registerUserRequest.getAge());
		userBusinessRules.isPasswordValid(registerUserRequest.getPassword());
		
		User user = modelMapperService.forRequest().map(registerUserRequest, User.class);
		
		String hashedPassword = PasswordHasher.hashPassword(registerUserRequest.getPassword());
		
		user.setPassword(hashedPassword);
		
		userRepository.save(user);
		
		changeLogService.logCreateDate(user);
		changeLogService.logCreatedBy(user, "Registration");
		
		
		
		return "Registered successfully";
		
	}
	
	
	
	
	
}
