package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance, Long>, FinanceQueryRepository {
}
