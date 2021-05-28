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
	private int answers_id;

	@Getter
	@Setter
	private Answer a;

	@Getter
	@Setter
	private Question q;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private String answer;

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws SQLException{

				//DB接続
				EntityManager em = DBUtil.createEntityManager();

				//DBから情報を取得
				Answer a = em.find(Answer.class, answers_id);
				Question q = em.find(Question.class, questions_id);

				this.question = q.getQuestion();
				this.answer = a.getAnswer();

				//DBとの接続を閉じる
				em.close();

		return SUCCESS;
	}
}
