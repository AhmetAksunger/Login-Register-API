package ahmetaksunger.loginRegister.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetaksunger.loginRegister.business.abstracts.ChangeLogService;
import ahmetaksunger.loginRegister.business.responses.GetAllChangeLogsResponse;
import ahmetaksunger.loginRegister.business.responses.GetByIdChangeLogResponse;
import ahmetaksunger.loginRegister.core.utilities.mappers.ModelMapperService;
import ahmetaksunger.loginRegister.dataAccess.abstracts.ChangeLogRepository;
import ahmetaksunger.loginRegister.entities.ChangeLog;
import ahmetaksunger.loginRegister.entities.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChangeLogManager implements ChangeLogService {
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	@Autowired
	private ModelMapperService mapperService;
	
	
	@Override
	public void logCreateDate(User user) {
		
		ChangeLog changeLog = new ChangeLog();
	
		changeLog.setUser(user);
		changeLog.setCreateDate();
		
		changeLogRepository.save(changeLog);
		
	}

	@Override
	public void logModifyDate(User user) {
		
		ChangeLog changeLog = changeLogRepository.findByUser(user);
		
		if(changeLog != null) {

			changeLog.setModifiedDate();
			
			changeLogRepository.save(changeLog);
			
			
		}
		
		
	}

	@Override
	public void logCreatedBy(User user,String createdBy) {
		
		ChangeLog changeLog = changeLogRepository.findByUser(user);
		
		changeLog.setCreatedBy(createdBy);
		
		changeLogRepository.save(changeLog);
		
		
	}

	@Override
	public List<GetAllChangeLogsResponse > getAll() {
		
		List<ChangeLog> logs = changeLogRepository.findAll();
		
		List<GetAllChangeLogsResponse> responses = logs.stream().map(changeLog->mapperService.forResponse().map(changeLog, GetAllChangeLogsResponse.class)).collect(Collectors.toList());
		
				
		return responses;
	
	}

	@Override
	public GetByIdChangeLogResponse getById(int id) {
		
		ChangeLog changeLog = changeLogRepository.findByUserId(id);
		
		GetByIdChangeLogResponse response = mapperService.forResponse().map(changeLog, GetByIdChangeLogResponse.class);
		
		return response;
	}

}
