package action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

	public String execute() throws SQLException{

		q.setQuestion(question);
		q.setCreated_at(currentTime);

		em.getTransaction().begin();
		em.persist(q);
		em.getTransaction().commit();

		@Transactional
		public void insertWithQuery(a){

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

			//        Query questions_id = em.createNativeQuery("insert into correct_answers where questions_id1 = ?1");

			for(int k =0; k < answer.length; k++) {
				em.createNativeQuery("insert into correct_answers (answer, questions_id, created_at) values (?, ?, ?)")
				.setParameter(1, answer[k])
				.setParameter(2, question_id)
				.setParameter(3, currentTime)
				.executeUpdate();
			}
			//        for(int k =0; k < answer.length -1; k++) {
			////        		questions_id.setParameter(1, question_id);
			////        		ans.setParameter(1, answer);
			//        	a.setQuestions_id(question_id);
			//        	a.setAnswer(answer[k]);
			//        	a.setCreated_at(currentTime);
			//        	em.getTransaction().begin();
			//        	em.persist(a);
			//        	em.getTransaction().commit();
			//        }

			//        for(int n =0; n < answer.length; n++) {
			//        	a.setQuestions_id(question_id);
			//        	a.setAnswer(answer[n]);
			//        	a.setCreated_at(currentTime);
			//        	em.getTransaction().begin();
			//        	em.persist(a);
			//            em.getTransaction().commit();
			//        }
		}
		em.close();
		return SUCCESS;
	}
}
