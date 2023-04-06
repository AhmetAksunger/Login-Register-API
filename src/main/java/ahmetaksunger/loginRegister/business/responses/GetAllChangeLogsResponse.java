package ahmetaksunger.loginRegister.business.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllChangeLogsResponse {

	private int userId;
	private String userFirstName;
	private String userLastName;
	private Date createDate;
	private Date modifiedDate;
	private String createdBy;
	
	
	
	
}
