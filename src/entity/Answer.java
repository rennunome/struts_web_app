package entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="correct_answers")
@NamedQueries({
	@NamedQuery(
			name = "findAllAnswerInfo",
			query = "SELECT a FROM Answer AS a"
			),
	@NamedQuery(
            name = "getAnswersCount",
            query = "SELECT COUNT(a) FROM Answer AS a"
            )
})

@Entity
public class Answer {

	@Getter
	@Setter
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Getter
	@Setter
	@Column(name="questions_id")
	private int questions_id;

//	@Getter
//	@Setter
//	@ManyToOne
//	@JoinColumn(name="id")
//	private Question question;

	@Getter
	@Setter
	@Column(name="answer")
	private String answer;

	@Getter
	@Setter
	@Column(name="created_at")
	private Timestamp created_at;

	@Getter
	@Setter
	@Column(name="updated_at")
	private Timestamp updated_at;
}
