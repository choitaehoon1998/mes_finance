package mes.broanex.finance.controller;

import mes.broanex.finance.entity.Administration;
import mes.broanex.finance.service.AdministrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class AdministrationController {
	private final AdministrationService administrationService;

	public AdministrationController(AdministrationService administrationService) {
		this.administrationService = administrationService;
	}

	@GetMapping(value = "administration")
	public ResponseEntity<List<Administration>> getAdministrationInfo() {
		List<Administration> administrationList = administrationService.findAllByParam(new HashMap<String, Object>() {{
			put("", "");
		}});
		return ok(administrationList);
	}

	@PostMapping(value = "administration", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewAdministration(@RequestPart(value = "administartion") Administration administration) {
		administrationService.saveNewAdministration(administration);
		return ok(null);
	}

	@PutMapping(value = "administration")
	public ResponseEntity<Void> updateAdministration(@RequestBody Administration administration) {
		administrationService.updateAdministration(administration);
		return ok(null);
	}
}
