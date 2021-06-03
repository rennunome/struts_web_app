package action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class MarkAction extends ActionSupport{

	@Getter
	@Setter
	private String[] test_answer;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private int[] questions_id;

	@Getter
	@Setter
	private int scr;

	@Getter
	@Setter
	private int qs;

	@Getter
	@Setter
	private int total;

	@Getter
	@Setter
	private Timestamp current_time;

	@Getter
	@Setter
	private int uid;

	@Getter
	@Setter
	private String name;

	public String execute() throws SQLException{

		double score = 0.0;

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//loop 1: test_answer分
		for(int i = 0; i < test_answer.length; i++) {
			//loop 2: questions_id分
			for(int j = 0; j < questions_id.length; j++) {
				//calistを取得
				List<Answer>calist = em.createNamedQuery("findAnswerByQuestionsId", Answer.class)
						.setParameter("questions_id", questions_id[j])
						.getResultList();
					//loop 3: calist分
					for(int k = 0; k < calist.size(); k++) {
						//if: calist.get(k).getAnswer(), test_answerの比較
						if(test_answer[k] == calist.get(k).getAnswer()) {
							score++;
						}
					}
				}
			}
		//DBとの接続を閉じる
		em.close();

		//整数スコア
		scr = (int)score;
		//問題数
		qs = questions_id.length;
		//採点結果を算出(正解数÷question_id.lengthの数の小数点以下切)
    	long total_score = Math.round(100 * scr /(double)qs);
    	total = (int) total_score;
    	//現在時刻を取得し、表示
    	long millis = System.currentTimeMillis();
		current_time = new Timestamp(millis);

		//user id取得
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		uid = (int)session.get("id"); //null
		//user name取得
		name = (String) session.get("name");

		return SUCCESS;

	}
}
