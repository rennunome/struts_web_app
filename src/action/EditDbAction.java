package action;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class EditDbAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private String answer;

	@Getter
	@Setter
	private int questions_id;

	@Getter
	@Setter
	private int answers_id;

	public String execute() throws SQLException{

		//DBとの接続
		EntityManager em = DBUtil.createEntityManager();

		//インスタンス化
		Question q = new Question();
		Answer a = new Answer();

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		q = em.find(Question.class, this.questions_id);

		q.setQuestion(this.question);
		q.setUpdated_at(currentTime);

		em.getTransaction().begin();
		em.persist(q);
		em.getTransaction().commit();

		//後に複数仕様に変更
		a = em.find(Answer.class, this.answers_id);

		a.setAnswer(this.answer);
		a.setUpdated_at(currentTime);

		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();

		return SUCCESS;
	}
}
