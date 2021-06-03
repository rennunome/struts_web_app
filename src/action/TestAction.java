package action;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class TestAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Question> questions;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private int id;

	public String execute() throws SQLException{

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//問題のListをランダムで取得して画面に渡す
		questions = em.createNamedQuery("findAllQuestionInfo", Question.class).getResultList();
		Collections.shuffle(questions);

		//DBとの接続を閉じる
		em.close();

		return SUCCESS;
	}
}
