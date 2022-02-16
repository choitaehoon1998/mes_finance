package mes.broanex.finance.service;

import mes.broanex.finance.entity.Contract;
import mes.broanex.finance.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ContractService {
	private final ContractRepository contractRepository;

	public ContractService(ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}

	public List<Contract> findAllByParam(HashMap<String, Object> hashMap) {
		return contractRepository.findAllByParam(hashMap);
	}

	public void saveNewContract(Contract contract) {
		Contract parentContract = contract.getParent();
		if (parentContract != null && isExistByContractCode(parentContract)) {
			parentContract = contractRepository.findByContractCode(parentContract.getContractCode());
			contract.setParent(parentContract);
		} else {
			contract.setParent(null);
			contract.setContractCode("");
		}
		contractRepository.save(contract);
	}

	public void updateContract(Contract contract) {
		if (contractRepository.existsById(contract.getIndexNo())) {
			contractRepository.save(contract);
		}
	}

	private boolean isExistByContractCode(Contract contract) {
		if (contract.getContractCode() != null && contractRepository.existByContractCode(contract.getContractCode())) {
			return true;
		}
		return false;
	}
}
