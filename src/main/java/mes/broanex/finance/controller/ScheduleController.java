package mes.broanex.finance.controller;

import mes.broanex.finance.entity.Schedule;
import mes.broanex.finance.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ScheduleController {
	private final ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@GetMapping(value = "schedule")
	public ResponseEntity<List<Schedule>> getSchedule(@RequestParam(required = false) Long indexNo,
	                                                  @RequestParam(required = false) Long revisionNo,
	                                                  @RequestParam(required = false) String isLast,
	                                                  @RequestParam(required = false) String name,
	                                                  @RequestParam(required = false) String content) {
		List<Schedule> scheduleList = scheduleService.findAllByParam(new HashMap<String, Object>() {{
			put("indexNo", indexNo);
			put("revisionNo", revisionNo);
			put("isLast", isLast);
			put("name", name);
			put("content", content);
		}});
		return ok(scheduleList);
	}

	@PostMapping(value = "schedule", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveSchedule(@RequestPart(value = "schedule") Schedule schedule) {
		scheduleService.saveNewSchedule(schedule);
		return ok(null);
	}

	@PutMapping(value = "schedule")
	public ResponseEntity<Void> updateSchedule(@RequestBody Schedule schedule) {
		scheduleService.updateSchedule(schedule);
		return ok(null);
	}

}
