package mes.broanex.finance.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "mes_material")
public class Material {
	@Id
	@Column(name = "index_no")
	private Long indexNo;

	@Column(name = "user_idx")
	private Long userIdx;

	@Column(name = "no")
	private String no;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "type")
	private String type;

	@Column(name = "regidate")
	private Timestamp regidate;

	@Column(name = "moddate")
	private Timestamp moddate;
}
