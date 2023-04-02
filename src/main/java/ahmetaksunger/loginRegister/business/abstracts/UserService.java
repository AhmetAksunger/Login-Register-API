package ahmetaksunger.loginRegister.business.abstracts;

import java.util.List;

import ahmetaksunger.loginRegister.business.requests.CreateUserRequest;
import ahmetaksunger.loginRegister.business.requests.UpdateUserRequest;
import ahmetaksunger.loginRegister.business.responses.GetAllUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByFirstNameUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByLastNameUserResponse;

public interface UserService {

	
	void add(CreateUserRequest createUserRequest);
	
	void update(UpdateUserRequest updateUserRequest);
	
	void remove(int id);
	
	GetByIdUserResponse getById(int id);
	
	List<GetByFirstNameUserResponse> getByFirstName(String firstName);
	
	List<GetByLastNameUserResponse> getByLastName(String lastName);
	
	List<GetAllUserResponse> getAll();
	
}
