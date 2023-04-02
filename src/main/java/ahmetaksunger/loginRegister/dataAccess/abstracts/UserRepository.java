package ahmetaksunger.loginRegister.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetaksunger.loginRegister.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> getByFirstName(String firstName);
	
	List<User> getByLastName(String lastName);
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);
	
	
}
