package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleQueryRepository {
	Schedule findFirst1ByOrderByIndexNoDesc();
}
