package ahmetaksunger.loginRegister.core.utilities.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import ahmetaksunger.loginRegister.business.responses.UserErrorResponse;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(NoSuchElementException exception){

		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(IncorrectPasswordException exception){

		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);

    }
	
	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(IncorrectMailException exception){

		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);

    }

	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(EmailInUseException exception){

		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<>(error,HttpStatus.CONFLICT);

    }
	
	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(BusinessException exception){

		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }

	
	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exception){

		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Unexpected error occured " + exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }	
	
}
