package mes.broanex.finance.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
@Setter
@Table(name = "mes_administration")
public class Administration implements Serializable {

	@Id
	@Column(name = "index_no")
	private Long indexNo;

	@Column(name = "administration_code" ,unique = true)
	private String administrationCode;

	@Column(name = "name")
	private String name;

	@Column(name = "user_idx")
	private String userIdx;

	@Column(name = "regidate")
	private Timestamp regidate;

	@Column(name = "moddate")
	private Timestamp moddate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_code",
			referencedColumnName = "administration_code")
	private Administration parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Administration> children = new ArrayList<>();
}
