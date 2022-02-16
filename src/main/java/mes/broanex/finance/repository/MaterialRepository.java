package mes.broanex.finance.repository;

import mes.broanex.finance.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long>, MaterialQueryRepository {
}
