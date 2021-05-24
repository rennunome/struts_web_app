package action;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class ListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Question> questions;

	@Getter
	@Setter
	private List<Answer> answers;

	public String execute() throws SQLException{
		String ret = SUCCESS;

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//DBから情報を取得
		questions = em.createNamedQuery("findAllQuestionInfo", Question.class).getResultList();
		answers = em.createNamedQuery("findAllAnswerInfo", Answer.class).getResultList();

		//DBとの接続を閉じる
		em.close();

		return ret;
	}
}