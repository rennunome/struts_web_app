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

@Table(name="histories")
@NamedQueries({
	@NamedQuery(
			name = "findHistoryByUserId",
			query = "SELECT h FROM History AS h WHERE h.user_id = :user_id"
			)
})

@Entity
public class History {

	@Getter
	@Setter
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Getter
	@Setter
	@Column(name="user_id")
	private int user_id;

	@Getter
	@Setter
	@Column(name="point")
	private int point;

	@Getter
	@Setter
	@Column(name="created_at")
	private Timestamp created_at;
}

