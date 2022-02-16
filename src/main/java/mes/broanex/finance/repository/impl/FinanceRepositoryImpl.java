package mes.broanex.finance.repository.impl;

import static mes.broanex.finance.entity.QFinance.finance;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.finance.entity.Finance;
import mes.broanex.finance.repository.FinanceQueryRepository;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class FinanceRepositoryImpl implements FinanceQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Finance> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(finance).fetch();
	}

}
