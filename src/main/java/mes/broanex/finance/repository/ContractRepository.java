package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long>, ContractQueryRepository {
	Contract findByContractCode(String contractCode);
}
