package action;

import java.sql.Timestamp;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class UserDeleteAction extends ActionSupport{

	@Getter
	@Setter
	private int user_id;

	public String execute() {

		EntityManager em = DBUtil.createEntityManager();

		User u = new User();

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		u = em.find(User.class, this.user_id);

		u.setDeleteflag((byte)1);
		u.setDeleted_at(currentTime);

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		return SUCCESS;

	}
}
