package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Material;

import java.util.HashMap;
import java.util.List;

public interface MaterialQueryRepository {
	List<Material> findByParam(HashMap<String, Object> hashMap);
}
