package action;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class MarkAction extends ActionSupport{

	@Getter
	@Setter
	private String test_answer;

	@Getter
	@Setter
	private String question;

	public String execute() throws SQLException{

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		String jql = "";

		Query query = em.createNativeQuery(jql);

		//loop 1: test_answers分

		//loop 2: questions_id分

		//if: questions_id, db questions_idの比較

		//loop 3: calist分

		//if: calist.get(k).getAnswer(), test_answerの比較

		//DBとの接続を閉じる
		em.close();

		return SUCCESS;

	}
}
