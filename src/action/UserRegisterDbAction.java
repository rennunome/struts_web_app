package action;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class UserRegisterDbAction extends ActionSupport{

	@Getter
	@Setter
	private String user_name;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String admin;

	@Getter
	@Setter
	private byte checkAdmin;

	public String execute() {

		if(admin == "true") {
			checkAdmin = 1;
		} else {
			checkAdmin = 0;
		}

		//DBとの接続
		EntityManager em = DBUtil.createEntityManager();

		User u = new User();

		u.setName(user_name);
		u.setPassword(password);
		u.setAdmin_flag(checkAdmin);

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		return SUCCESS;
	}
}
