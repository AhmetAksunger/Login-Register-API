package ahmetaksunger.loginRegister.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;
	
}
