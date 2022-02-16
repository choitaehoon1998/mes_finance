package mes.broanex.finance.repository.impl;

import static mes.broanex.finance.entity.QContract.contract;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.finance.entity.Contract;
import mes.broanex.finance.repository.ContractQueryRepository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Contract> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(contract).fetch();
	}

	@Override
	public boolean existByContractCode(String contractCode) {
		Integer result = queryFactory
				.selectOne()
				.from(contract)
				.where(eqContractCode(contractCode))
				.fetchFirst();
		return result != null;
	}

	private BooleanExpression eqContractCode(String contractCode) {
		if (StringUtils.hasText(contractCode)) {
			return contract.contractCode.eq(contractCode);
		}
		return null;
	}
}
