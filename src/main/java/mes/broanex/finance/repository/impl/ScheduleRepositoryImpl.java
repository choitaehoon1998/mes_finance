package mes.broanex.finance.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.finance.entity.Schedule;
import mes.broanex.finance.repository.ScheduleQueryRepository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.finance.entity.QSchedule.schedule;

@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleQueryRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Schedule> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(schedule).where(
				eqIndexNo((Long) hashMap.get("indexNo")),
				eqRevisionNo((Long) hashMap.get("revisionNo")),
				eqIsLast((String) hashMap.get("isLast")),
				eqName((String) hashMap.get("name")),
				eqContent((String) hashMap.get("content"))
		).fetch();
	}

	private BooleanExpression eqIndexNo(Long indexNo) {
		if (indexNo == null) {
			return null;
		}
		return schedule.indexNo.eq(indexNo);
	}

	private BooleanExpression eqRevisionNo(Long revisionNo) {
		if (revisionNo == null) {
			return null;
		}
		return schedule.revisionNo.eq(revisionNo);
	}

	private BooleanExpression eqIsLast(String isLast) {
		if (StringUtils.hasText(isLast)) {
			return schedule.isLast.eq(isLast);
		}
		return null;
	}

	private BooleanExpression eqName(String name) {
		if (StringUtils.hasText(name)) {
			return schedule.name.eq(name);
		}
		return null;
	}

	private BooleanExpression eqContent(String content) {
		if (StringUtils.hasText(content)) {
			return schedule.content.eq(content);
		}
		return null;
	}
}
