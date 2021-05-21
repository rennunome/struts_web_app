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
	private int qid;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private int aid;

	@Getter
	@Setter
	private int questions_id;

	@Getter
	@Setter
	private String answer;

	public String excute() throws SQLException{
		String ret = null;

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//DBからユーザー情報を取得
		List<Question> questions = em.createNamedQuery("findAllQuestionInfo", Question.class).getResultList();
		List<Answer> answers = em.createNamedQuery("findAllAnswerInfo", Answer.class).getResultList();

		//DBとの接続を閉じる
		em.close();

		if(question != null && qid != 0) {
			for(int i = 0; i < questions.size(); i++) {
				qid = questions.get(i).getId();
				question = questions.get(i).getQuestion();
				ret = SUCCESS;
			}
		}

		if(answer != null && aid != 0) {
			for(int i = 0; i < answers.size(); i++) {
				aid = answers.get(i).getId();
				questions_id = answers.get(i).getQuestions_id();
				answer = answers.get(i).getAnswer();
				ret = SUCCESS;
			}
		}
		return ret;
	}
}