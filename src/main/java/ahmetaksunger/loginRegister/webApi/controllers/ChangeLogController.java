package ahmetaksunger.loginRegister.webApi.controllers;

import java.util.List;

import ahmetaksunger.loginRegister.business.responses.GetByCreatedByResponse;
import ahmetaksunger.loginRegister.business.responses.GetByFirstNameOrLastNameChangeLogsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetaksunger.loginRegister.business.abstracts.ChangeLogService;
import ahmetaksunger.loginRegister.business.responses.GetAllChangeLogsResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdChangeLogResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/changelog")
public class ChangeLogController {

	@Autowired
	private ChangeLogService changeLogService;
	
	@GetMapping("/getall")
	public List<GetAllChangeLogsResponse> getAll() {
		
		return changeLogService.getAll();
		
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdChangeLogResponse getById(@PathVariable int id) {
		
		return changeLogService.getById(id);
		
	}

	@GetMapping("/getbycreatedby")
	public List<GetByCreatedByResponse> getByCreatedBy(String search){

		return changeLogService.getByCreatedBy(search);
	}

	@GetMapping("/getbyfirstnameorlastname")
	public List<GetByFirstNameOrLastNameChangeLogsResponse> getByFirstNameOrLastName(String search){

		return changeLogService.getByUserFirstNameOrUserLastName(search);
	}
	
}
