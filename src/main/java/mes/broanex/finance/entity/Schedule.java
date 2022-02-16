package mes.broanex.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Table(name = "mes_schedule",
		uniqueConstraints = @UniqueConstraint(columnNames = {"schedule_no", "revision_no"}))
public class Schedule {
	@Id
	@Column(name = "index_no")
	private Long indexNo;

	@Column(name = "schedule_no")
	private Long scheduleNo;

	@Column(name = "revision_no")
	private Long revisionNo;

	@Column(name = "user_idx")
	private Long userIdx;

	@Column(name = "is_last", length = 1)
	private String isLast;

	@Column(name = "name")
	private String name;

	@Column(name = "content", length = 2000)
	private String content;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "regidate")
	private Timestamp regidate;

	@Column(name = "moddate")
	private Timestamp moddate;
}
