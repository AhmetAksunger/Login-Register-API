package ahmetaksunger.loginRegister.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetaksunger.loginRegister.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> getByFirstName(String firstName);
	
	List<User> getByLastName(String lastName);
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);

	List<User> findAllByOrderByFirstNameAsc();

	@Query("SELECT u FROM User u WHERE LOWER(u.firstName) LIKE %:search% OR LOWER(u.lastName) LIKE %:search%")
	List<User> findByFirstNameOrLastName(String search);

	//findByFirstNameOrLastName(String search1, String search2) would also work if i gave the same string to each parameters
	
}
