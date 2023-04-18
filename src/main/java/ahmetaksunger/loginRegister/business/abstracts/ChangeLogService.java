package ahmetaksunger.loginRegister.business.abstracts;

import java.util.List;

import ahmetaksunger.loginRegister.business.responses.GetAllChangeLogsResponse;
import ahmetaksunger.loginRegister.business.responses.GetByCreatedByResponse;
import ahmetaksunger.loginRegister.business.responses.GetByFirstNameOrLastNameChangeLogsResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdChangeLogResponse;
import ahmetaksunger.loginRegister.entities.User;

public interface ChangeLogService {

	void logCreateDate(User user);
	void logModifyDate(User user);
	void logCreatedBy(User user,String createdBy);
	
	List<GetAllChangeLogsResponse> getAll();
	GetByIdChangeLogResponse getById(int id);

	List<GetByCreatedByResponse> getByCreatedBy(String search);

	List<GetByFirstNameOrLastNameChangeLogsResponse> getByUserFirstNameOrUserLastName(String search);
}
