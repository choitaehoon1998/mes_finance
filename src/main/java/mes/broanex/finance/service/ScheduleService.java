package mes.broanex.finance.service;

import mes.broanex.finance.entity.Schedule;
import mes.broanex.finance.repository.ScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public ScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	public List<Schedule> findAllByParam(HashMap<String, Object> hashMap) {
		List<Schedule> scheduleList = scheduleRepository.findByParam(hashMap);
		return scheduleList;
	}

	public void saveNewSchedule(Schedule schedule) {
		Schedule schedule1 = scheduleRepository.findFirst1ByOrderByIndexNoDesc();
		if (schedule1 == null) {
			schedule.setIndexNo(1L);
		} else {
			schedule.setIndexNo(schedule1.getIndexNo() + 1);
		}
		schedule.setRevisionNo(1L);
		schedule.setIsLast("Y");

		schedule.setModdate(Timestamp.valueOf(LocalDateTime.now()));
		schedule.setRegidate(Timestamp.valueOf(LocalDateTime.now()));

		scheduleRepository.save(schedule);
	}

	public void updateSchedule(Schedule schedule) {
		if (scheduleRepository.existsById(schedule.getIndexNo())) {
			// 이전 버전의 scedule 값 중 isLast를 N 으로 바꾸고
			Schedule dbSchedule = scheduleRepository.getById(schedule.getIndexNo());

			dbSchedule.setIsLast("N");
			dbSchedule.setModdate(Timestamp.valueOf(LocalDateTime.now()));
			scheduleRepository.save(dbSchedule);

			Schedule newSchedule = new Schedule();
			BeanUtils.copyProperties(schedule, newSchedule ,"indexNo");

			newSchedule.setRevisionNo(dbSchedule.getRevisionNo() + 1);
			newSchedule.setIsLast("Y");
			newSchedule.setRegidate(Timestamp.valueOf(LocalDateTime.now()));
			newSchedule.setModdate(Timestamp.valueOf(LocalDateTime.now()));
			Schedule schedule1 = scheduleRepository.findFirst1ByOrderByIndexNoDesc();
			newSchedule.setIndexNo(schedule1.getIndexNo() + 1);
			scheduleRepository.save(newSchedule);
		}
	}
}
