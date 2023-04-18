package ahmetaksunger.loginRegister.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetaksunger.loginRegister.entities.ChangeLog;
import ahmetaksunger.loginRegister.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Integer>{

	ChangeLog findByUser(User user);
	
	ChangeLog findByUserId(int id);

	List<ChangeLog> findByCreatedBy(String search);

	@Query("SELECT c FROM ChangeLog c WHERE LOWER(c.user.firstName) LIKE %:search% OR LOWER(c.user.lastName) LIKE %:search%")
	List<ChangeLog> findByUserFirstNameOrUserLastName(String search);

}
