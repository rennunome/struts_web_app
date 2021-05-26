package action;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class DeleteConfirmAction extends ActionSupport {

	@Getter
	@Setter
	private int questions_id;

	@Getter
	@Setter
	private Answer a;

	@Getter
	@Setter
	private Question q;

	@Getter
	@Setter
	private String question;

	private static final long serialVersionUID = 1L;

	public String execute() throws SQLException{

		System.out.println(questions_id); //0

				//DB接続
				EntityManager em = DBUtil.createEntityManager();

				//DBから情報を取得
				Answer a = em.find(Answer.class, questions_id);
				Question q = em.find(Question.class, questions_id);

				//DBとの接続を閉じる
				em.close();

				String question = q.getQuestion();

		return SUCCESS;
	}
}
