package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrationRepository extends JpaRepository<Administration, Long>, AdministrationQueryRepository {
	Administration findByAdministrationCode(String administrationCode);
}
