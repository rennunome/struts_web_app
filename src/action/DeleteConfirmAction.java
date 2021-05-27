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

	public String execute() throws SQLException{

				//DB接続
				EntityManager em = DBUtil.createEntityManager();

				//DBから情報を取得
				Answer a = em.find(Answer.class, answers_id);
				Question q = em.find(Question.class, questions_id);

				//DBとの接続を閉じる
				em.close();

				String question = q.getQuestion();
				String answer = a.getAnswer();

				System.out.println("クエスチョンは" + question); //出力される
				System.out.println("アンサーは" + answer); //出力される

		return SUCCESS;
	}
}
