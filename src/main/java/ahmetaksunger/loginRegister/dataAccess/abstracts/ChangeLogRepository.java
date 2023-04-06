package ahmetaksunger.loginRegister.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetaksunger.loginRegister.entities.ChangeLog;
import ahmetaksunger.loginRegister.entities.User;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Integer>{

	ChangeLog findByUser(User user);
	
	ChangeLog findByUserId(int id);
}
