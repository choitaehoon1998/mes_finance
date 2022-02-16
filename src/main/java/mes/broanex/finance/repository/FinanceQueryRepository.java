package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Finance;

import java.util.HashMap;
import java.util.List;

public interface FinanceQueryRepository {
	List<Finance> findAllByParam(HashMap<String, Object> hashMap);
}
