package action;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.History;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class HistoryAction extends ActionSupport{

	@Getter
	@Setter
	private List<History> hlist;

	public String execute() {

		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		//user id取得
		int uid = (int)session.get("user_id");

		//point, created_at取得
		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		hlist = em.createNamedQuery("findHistoryByUserId", History.class)
		.setParameter("user_id", uid)
		.getResultList();

		em.close();

		return SUCCESS;
	}
}
