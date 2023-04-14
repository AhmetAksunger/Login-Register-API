package ahmetaksunger.loginRegister.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetaksunger.loginRegister.core.utilities.exceptions.BusinessException;
import ahmetaksunger.loginRegister.core.utilities.exceptions.EmailInUseException;
import ahmetaksunger.loginRegister.dataAccess.abstracts.UserRepository;
import lombok.Data;

@Data
@Service
public class UserBusinessRules {

	@Autowired
	private UserRepository userRepository;
	
	
	public void checkIfEmailExists(String email) {
		
		if(userRepository.existsByEmail(email)) {
			
			throw new EmailInUseException("Email is in use");
			
		}
		
		
	}
	
	public void isAgeValid(int age) {
		
		if(age<18) {
			
			throw new BusinessException("Must be older than 18, given " + age);
			
		}else if(age>100) {
			
			throw new BusinessException("Age must be between 18 and 100");
			
		}
		
	}
	
	public void isPasswordValid(String password) {
		
		if(password.length() < 5) {
			
			throw new BusinessException("Password must be longer than 5 chars");
			
		}else if(!password.matches(".*\\d.*")) {
			
			throw new BusinessException("Password must contain at least one digit");
		}
		
		
	}
	
	public void confirmPassword(String password, String confirmPassword) {
		
		if(!password.equals(confirmPassword)) {

			throw new BusinessException("Passwords do not match");
		}
		
	}
	
}
