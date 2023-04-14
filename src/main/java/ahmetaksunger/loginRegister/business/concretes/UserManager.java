package ahmetaksunger.loginRegister.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetaksunger.loginRegister.business.abstracts.ChangeLogService;
import ahmetaksunger.loginRegister.business.abstracts.UserService;
import ahmetaksunger.loginRegister.business.requests.CreateUserRequest;
import ahmetaksunger.loginRegister.business.requests.UpdateUserRequest;
import ahmetaksunger.loginRegister.business.responses.GetAllUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByFirstNameUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByLastNameUserResponse;
import ahmetaksunger.loginRegister.business.rules.UserBusinessRules;
import ahmetaksunger.loginRegister.core.utilities.mappers.ModelMapperService;
import ahmetaksunger.loginRegister.core.utilities.passwordHasher.PasswordHasher;
import ahmetaksunger.loginRegister.dataAccess.abstracts.UserRepository;
import ahmetaksunger.loginRegister.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserManager implements UserService{

	@Autowired
	private ChangeLogService changeLogService;
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapperService mapperService;
	
	@Autowired
	private UserBusinessRules userBusinessRules;
	
	@Override
	public void add(CreateUserRequest createUserRequest) {
		
		userBusinessRules.checkIfEmailExists(createUserRequest.getEmail());
		userBusinessRules.isAgeValid(createUserRequest.getAge());
		userBusinessRules.isPasswordValid(createUserRequest.getPassword());
		
		String hashedPassword = PasswordHasher.hashPassword(createUserRequest.getPassword());
		
		User user = mapperService.forRequest().map(createUserRequest, User.class);
		
		user.setPassword(hashedPassword);
		
		userRepository.save(user);
		
		changeLogService.logCreateDate(user);
		changeLogService.logCreatedBy(user, "Admin");
		
	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		
		
		User user = userRepository.findById(updateUserRequest.getId()).orElseThrow();
		
		userBusinessRules.isAgeValid(updateUserRequest.getAge());
		userBusinessRules.isPasswordValid(updateUserRequest.getPassword());
		
		
		user = mapperService.forRequest().map(updateUserRequest, User.class);
		
		if(updateUserRequest.getEmail() != user.getEmail()) {
			
			userBusinessRules.checkIfEmailExists(updateUserRequest.getEmail());	
			
		}
		
		String hashedPassword = PasswordHasher.hashPassword(updateUserRequest.getPassword());
		
		user.setPassword(hashedPassword);
		
		userRepository.save(user);
		
		changeLogService.logModifyDate(user);
		
	}

	@Override
	public void remove(int id) {
		
		userRepository.deleteById(id);
		
	}

	@Override
	public GetByIdUserResponse getById(int id) {
		
		User user = userRepository.findById(id).orElseThrow();
		
		GetByIdUserResponse response = mapperService.forResponse().map(user, GetByIdUserResponse.class);
		
		return response;
		
	}

	@Override
	public List<GetByFirstNameUserResponse> getByFirstName(String firstName) {
		
		List<User> users = userRepository.getByFirstName(firstName);
		
		List<GetByFirstNameUserResponse> responses = users.stream().map(user->mapperService.forResponse()
				.map(user, GetByFirstNameUserResponse.class)).collect(Collectors.toList());
		
		
		return responses;
	}

	@Override
	public List<GetByLastNameUserResponse> getByLastName(String lastName) {
		
		List<User> users = userRepository.getByLastName(lastName);
		
		List<GetByLastNameUserResponse> responses = users.stream().map(user->mapperService.forResponse()
				.map(user, GetByLastNameUserResponse.class)).collect(Collectors.toList());
		
		
		return responses;
	}

	@Override
	public List<GetAllUserResponse> getAll() {
		
		List<User> users = userRepository.findAll();
		
		List<GetAllUserResponse> responses = users.stream().map(user->mapperService.forResponse()
				.map(user, GetAllUserResponse.class)).collect(Collectors.toList());
		
		return responses;
	}

	
}
