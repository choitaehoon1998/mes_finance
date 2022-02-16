package mes.broanex.finance.service;

import mes.broanex.finance.entity.Finance;
import mes.broanex.finance.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class FinanceService {
	private final FinanceRepository financeRepository;

	public FinanceService(FinanceRepository financeRepository) {
		this.financeRepository = financeRepository;
	}

	public List<Finance> getAllByParam(HashMap<String, Object> hashMap) {
		List<Finance> financeList = financeRepository.findAllByParam(hashMap);
		return financeList;
	}

	public void createNewFinance(Finance finance) {
		finance.setModdate(Timestamp.valueOf(LocalDateTime.now()));
		financeRepository.save(finance);
	}

	public void updateFinance(Finance finance) {
		if (financeRepository.existsById(finance.getIndexNo())) {
			finance.setModdate(Timestamp.valueOf(LocalDateTime.now()));
			financeRepository.save(finance);
		}
	}
}
