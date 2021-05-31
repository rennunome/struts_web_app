package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class TestAction extends ActionSupport{

	@Getter
	@Setter
	private List<Question> qList;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private int id;

	public String execute() throws SQLException{

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		List<Question> questions = em.createNamedQuery("findAllQuestionInfo", Question.class).getResultList();
		Collections.shuffle(questions);

		//DBとの接続を閉じる
		em.close();

		qList = new ArrayList<Question>();
		for(int i =0; i < questions.size(); i++) {
			Question q = new Question();
			String question = questions.get(i).getQuestion();
			int id = questions.get(i).getId();
			q.setId(id);
			q.setQuestion(question);
			qList.add(q);
		}

		for(int i =0; i < qList.size(); i++) {
			System.out.println(qList.get(i).getQuestion());
		}

		return SUCCESS;
	}
}
