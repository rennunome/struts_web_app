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

@Entity
@NamedQueries({
	@NamedQuery(
			name = "findAllUserInfo",
			query = "SELECT u FROM User AS u ORDER BY u.id DESC"
			),
	@NamedQuery(
			name = "findAllUsers",
			query = "SELECT u FROM User AS u WHERE u.deleteflag = 0"
			)
})

@Table(name="users")
public class User {

	@Getter
	@Setter
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Getter
	@Setter
	@Column(name="name")
	private String name;

	@Getter
	@Setter
	@Column(name="password")
	private String password;

	@Getter
	@Setter
	@Column(name="created_at")
	private  Timestamp created_at;

	@Getter
	@Setter
	@Column(name="updated_at")
	private  Timestamp updated_at;

	@Getter
	@Setter
	@Column(name="deleteflag")
	private byte deleteflag;

	@Getter
	@Setter
	@Column(name="deleted_at")
	private  Timestamp deleted_at;


	@Getter
	@Setter
	@Column(name="admin_flag")
	private byte admin_flag;


	}
