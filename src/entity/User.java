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

@Entity
@NamedQueries({
	@NamedQuery(
			name = "findAllUserInfo",
			query = "SELECT u FROM User AS u ORDER BY u.id DESC"
			)
})

@Table(name="users")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;

	@Column(name="created_at")
	private  Timestamp created_at;

	@Column(name="updated_at")
	private  Timestamp updated_at;

	@Column(name="deleteflag")
	private  byte deleteflag;

	@Column(name="deleted_at")
	private  Timestamp deleted_at;

	@Column(name="admin_flag")
	private  byte admin_flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public byte getDeleteFlag() {
		return deleteflag;
	}

	public void setDeleteFlag(byte deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Timestamp getDeletedAt() {
		return deleted_at;
	}

	public void setDeletedAt(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	public byte getAdminFlag() {
		return deleteflag;
	}

	public void setAdminFlag(byte admin_flag) {
		this.admin_flag = admin_flag;
	}
}
