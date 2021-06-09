package action;

import java.util.List;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class UserListAction extends ActionSupport{

	@Getter
	@Setter
	private List<User> users;

	public String execute() {

		EntityManager em = DBUtil.createEntityManager();

		users = em.createNamedQuery("findAllUsers", User.class).getResultList();

		em.close();

		return SUCCESS;
	}
}
