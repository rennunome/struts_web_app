package action;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class DeleteAction extends ActionSupport{

	@Getter
	@Setter
	private int questions_id;

	@Getter
	@Setter
	private int answers_id;

	@Override
	public String execute() throws SQLException{

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//削除処理
		Question q = em.find(Question.class, questions_id);
		Answer a = em.find(Answer.class, answers_id);
		em.getTransaction().begin();
        em.remove(q);
        em.remove(a);
        em.getTransaction().commit();

		//DBとの接続を閉じる
		em.close();

		return SUCCESS;
	}
}
