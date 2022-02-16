package mes.broanex.finance.controller;

import mes.broanex.finance.entity.Contract;
import mes.broanex.finance.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ContractController {

	private final ContractService contractService;

	public ContractController(ContractService contractService) {
		this.contractService = contractService;
	}

	@GetMapping(value = "contract")
	public ResponseEntity<List<Contract>> getContractInfo() {
		List<Contract> contractList = contractService.findAllByParam(new HashMap<String, Object>() {{
			put("", "");
		}});
		return ok(contractList);
	}

	@PostMapping(value = "contract", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> createContract(@RequestPart(value = "contract") Contract contract) {
		contractService.saveNewContract(contract);
		return ok(null);
	}

	@PutMapping(value = "contract")
	public ResponseEntity<Void> updateContract(@RequestBody Contract contract) {
		contractService.updateContract(contract);
		return ok(null);
	}

}
