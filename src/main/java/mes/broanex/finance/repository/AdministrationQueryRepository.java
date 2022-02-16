package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Administration;

import java.util.HashMap;
import java.util.List;

public interface AdministrationQueryRepository {
	boolean existsByAdministrationCode(String administrationCode);

	List<Administration> findByParam(HashMap<String, Object> hashMap);
}
