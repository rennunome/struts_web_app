package action;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class EditAction extends ActionSupport{

	@Getter
	@Setter
	private int questions_id;

	@Getter
	@Setter
	//後でint[]に修正
	private int answers_id;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	//後でString[]に修正
	private String answer;

	@Override
	public String execute() throws SQLException{

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		Question q = em.find(Question.class, this.questions_id);
		Answer a = em.find(Answer.class, this.answers_id);

		//DBとの接続を閉じる
		em.close();

		question = q.getQuestion();
		q.setQuestion(question);

		answer = a.getAnswer();
		a.setAnswer(answer);

		return SUCCESS;
	}
}
