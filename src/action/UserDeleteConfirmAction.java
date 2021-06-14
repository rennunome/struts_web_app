package action;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class UserDeleteConfirmAction extends ActionSupport{

	@Getter
	@Setter
	private int user_id;

	@Getter
	@Setter
	private String user_name;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private byte admin_flag;

	public String execute() {

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		User u = em.find(User.class, user_id);

		user_name = u.getName();
		password = u.getPassword();
		admin_flag = u.getAdmin_flag();

		em.close();

		return SUCCESS;

	}
}
