package ahmetaksunger.loginRegister.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetByIdUserResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	
}
