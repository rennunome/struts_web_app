package action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class RegisterDbAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String question;
	@Getter
	@Setter
	private String[] answer;

	//DBとの接続
	EntityManager em = DBUtil.createEntityManager();

	//インスタンス化
	Question q = new Question();
	Answer a = new Answer();

	Timestamp currentTime = new Timestamp(System.currentTimeMillis());

	@Override
	public String execute() throws SQLException{

		q.setQuestion(question);
		q.setCreated_at(currentTime);

		em.getTransaction().begin();
		em.persist(q);
		em.getTransaction().commit();


			//last inserted idを取得
			List<Question> question = em.createNamedQuery("findAllQuestionInfoByTimeCreated", Question.class).getResultList();

			int qid = 0;
			int question_id = 0;

			for(int i = 0; i < question.size(); i++) {
				qid = question.get(i).getId();
			}

			ArrayList<Integer> q_id = new ArrayList<Integer>();
			q_id.add(qid);
			question_id = q_id.get(0);

			em.getTransaction().begin();

			for(int k =0; k < answer.length; k++) {
				String jql = "insert into correct_answers (answer, questions_id, created_at) values (?1, ?2, ?3)";
				Query query = em.createNativeQuery(jql);
						query.setParameter(1, answer[k]);
						query.setParameter(2, question_id);
				        query.setParameter(3, currentTime);
				        query.executeUpdate();
				        }
			 em.getTransaction().commit();

		return SUCCESS;
	}
}
