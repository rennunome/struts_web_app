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
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Table(name="questions", uniqueConstraints={@UniqueConstraint(columnNames={"question"})})
@NamedQueries({
	@NamedQuery(
			name = "findAllQuestionInfo",
			query = "SELECT q FROM Question AS q"
			),
	@NamedQuery(
			name = "findAllQuestionInfoByTimeCreated",
			query = "SELECT q FROM Question AS q ORDER BY q.created_at ASC"
			),
	@NamedQuery(
            name = "getQuestionsCount",
            query = "SELECT COUNT(q) FROM Question AS q"
            ),
})

@Entity
public class Question {

	@Getter
	@Setter
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Getter
	@Setter
	@Column(name="question", unique=true)
	private String question;


	@Getter
	@Setter
	@Column(name="created_at")
	private Timestamp created_at;


	@Getter
	@Setter
	@Column(name="updated_at")
	private Timestamp updated_at;
}