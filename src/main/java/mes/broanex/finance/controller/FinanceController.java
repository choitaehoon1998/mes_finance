package mes.broanex.finance.controller;

import mes.broanex.finance.entity.Finance;
import mes.broanex.finance.service.FinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class FinanceController {

	private final FinanceService financeService;

	public FinanceController(FinanceService financeService) {
		this.financeService = financeService;
	}

	@GetMapping(value = "finance")
	public ResponseEntity<List<Finance>> getFinanceInfo() {
		List<Finance> financeList = financeService.getAllByParam(new HashMap<String, Object>() {{
			put("", "");
		}});
		return ok(financeList);
	}

	@PostMapping(value = "finance", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewFinance(@RequestPart(name = "finance") Finance finance) {
		financeService.createNewFinance(finance);
		return ok(null);
	}

	@PutMapping(value = "finance")
	public ResponseEntity<Void> updateFinance(@RequestBody Finance finance) {
		financeService.updateFinance(finance);
		return ok(null);
	}
}
