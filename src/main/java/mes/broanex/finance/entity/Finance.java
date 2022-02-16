package mes.broanex.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Table(name = "mes_finance")
public class Finance {
	@Id
	@Column(name = "index_no")
	private Long indexNo;

	@Column(name = "user_idx")
	private Long userIdx;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "unit_price")
	private Long unitPrice;

	@Column(name = "sale_price")
	private Long salePrice;

	@Column(name = "raw_material")
	private String rawMaterial;

	@Column(name = "subsidiary_material")
	private String subsidiaryMaterial;

	@Column(name = "outsource")
	private String outsource;

	@Column(name = "wood_mold")
	private String woodMold;

	@Column(name = "subcontract")
	private String subcontract;

	@Column(name = "fee")
	private Long fee;

	@Column(name = "total")
	private Long total;

	@Column(name = "origin_percent")
	private Long originPercent;

	@Column(name = "ks_jungmil")
	private String ksJungmil;

	@Column(name = "jk_jungmil")
	private String jkJungmil;

	@Column(name = "sj_mtech")
	private String sjMtech;

	@Column(name = "sw_tech")
	private String swTech;

	@Column(name = "sm_tech")
	private String smTech;

	@Column(name = "su_industry")
	private String suIndustry;

	@Column(name = "ss_coat")
	private String ssCoat;

	@Column(name = "partner_total")
	private Long partnerTotal;

	@Column(name = "partner_percent")
	private Long partnerPercent;

	@Column(name = "unit_price_total")
	private Long unitPriceTotal;

	@Column(name = "profit_loss")
	private Long profitLoss;

	@Column(name = "percent")
	private Long percent;

	@Column(name = "regidate")
	private Timestamp regidate;

	@Column(name = "moddate")
	private Timestamp moddate;
}
