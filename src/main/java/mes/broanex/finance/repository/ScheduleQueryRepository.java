package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Schedule;

import java.util.HashMap;
import java.util.List;

public interface ScheduleQueryRepository {
	List<Schedule> findByParam(HashMap<String, Object> hashMap);
}
