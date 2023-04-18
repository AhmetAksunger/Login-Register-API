package ahmetaksunger.loginRegister.webApi.controllers;

import java.util.List;

import ahmetaksunger.loginRegister.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ahmetaksunger.loginRegister.business.abstracts.UserService;
import ahmetaksunger.loginRegister.business.requests.CreateUserRequest;
import ahmetaksunger.loginRegister.business.requests.UpdateUserRequest;
import ahmetaksunger.loginRegister.business.responses.GetAllUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByFirstNameUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdUserResponse;
import ahmetaksunger.loginRegister.business.responses.GetByLastNameUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@GetMapping("/add")
	public void add(@Valid CreateUserRequest createUserRequest) {
		
		userService.add(createUserRequest);
		
		
	}
	
	@PutMapping("/update")
	public void update(UpdateUserRequest updateUserRequest) {
		
		userService.update(updateUserRequest);
		
	}
	
	@DeleteMapping("/remove/{id}")
	public void remove(@Valid @PathVariable int id) {
		
		userService.remove(id);
	}
	
	@GetMapping("/getbyid/{id}")
	GetByIdUserResponse getById(@Valid @PathVariable int id) {
		
		return userService.getById(id);
		
	}
	
	@GetMapping("/getbyfirstname/{firstName}")
	List<GetByFirstNameUserResponse> getByFirstName(@Valid @PathVariable String firstName){
		
		return userService.getByFirstName(firstName);
		
	}
	
	@GetMapping("/getbylastname/{lastName}")
	List<GetByLastNameUserResponse> getByLastName(@PathVariable String lastName){
		
		return userService.getByLastName(lastName);
	}
	
	@GetMapping("/getall")
	List<GetAllUserResponse> getAll(){
		
		return userService.getAll();
		
	}

	@GetMapping("/getbyfirstnameorlastname")
	List<GetAllUserResponse> getByFirstNameOrLastName(String search){
		List<GetAllUserResponse> users = userService.findByFirstNameOrLastName(search);

		return users;
	}

	
}
