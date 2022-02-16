package mes.broanex.finance.repository.impl;

import static mes.broanex.finance.entity.QAdministration.administration;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.finance.entity.Administration;
import mes.broanex.finance.repository.AdministrationQueryRepository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class AdministrationRepositoryImpl implements AdministrationQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Administration> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(administration).fetch();
	}

	@Override
	public boolean existsByAdministrationCode(String administrationCode) {
		Integer result = queryFactory
				.selectOne()
				.from(administration)
				.where(eqAdministrationCode(administrationCode))
				.fetchFirst();
		return result != null;
	}

	private BooleanExpression eqAdministrationCode(String administrationCode) {
		if (StringUtils.hasText(administrationCode)) {
			return administration.administrationCode.eq(administrationCode);
		}
		return null;
	}
}
