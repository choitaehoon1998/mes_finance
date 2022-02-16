package mes.broanex.finance.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.finance.entity.Material;
import mes.broanex.finance.repository.MaterialQueryRepository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.finance.entity.QMaterial.material;

@RequiredArgsConstructor
public class MaterialRepositoryImpl implements MaterialQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Material> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(material).where(
				eqIndexNo((Long) hashMap.get("indexNo")),
				eqNo((String) hashMap.get("no")),
				eqName((String) hashMap.get("name")),
				eqCode((String) hashMap.get("code")),
				eqQuantity((Long) hashMap.get("quantity")),
				eqType((String) hashMap.get("type"))
		).fetch();
	}

	private BooleanExpression eqIndexNo(Long indexNo) {
		if (indexNo == null) {
			return null;
		}
		return material.indexNo.eq(indexNo);
	}

	private BooleanExpression eqNo(String no) {
		if (StringUtils.hasText(no)) {
			return material.no.eq(no);
		}
		return null;
	}

	private BooleanExpression eqName(String name) {
		if (StringUtils.hasText(name)) {
			return material.name.eq(name);
		}
		return null;
	}

	private BooleanExpression eqCode(String code) {
		if (StringUtils.hasText(code)) {
			return material.code.eq(code);
		}
		return null;
	}

	private BooleanExpression eqQuantity(Long quantity) {
		if (quantity == null) {
			return null;
		}
		return material.quantity.eq(quantity);
	}

	private BooleanExpression eqType(String type) {
		if (StringUtils.hasText(type)) {
			return material.type.eq(type);
		}
		return null;
	}
}
