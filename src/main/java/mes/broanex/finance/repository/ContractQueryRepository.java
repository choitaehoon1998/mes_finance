package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Contract;

import java.util.HashMap;
import java.util.List;

public interface ContractQueryRepository {
	List<Contract> findAllByParam(HashMap<String, Object> hashMap);

	boolean existByContractCode(String contractCode);
}
