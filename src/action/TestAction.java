package action;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class TestAction extends ActionSupport{

	@Getter
	@Setter
	private List<Query> list;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	private int id;

	public String execute() throws SQLException{

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//questionのみを渡す成功例
//		String jql = "Select question from questions order by rand()";
//
//		Query query = em.createNativeQuery(jql);
//
//		list = query.getResultList();

//		System.out.println(query.toString()); //org.hibernate.query.internal.NativeQueryImpl@3ae1093b

		//Select id, questionはうまく取得できず
		String jql = "Select id, question from questions order by rand()";

		Query query = em.createNativeQuery(jql);

		list = query.getResultList();

		for(int i =0; i < list.size(); i++) {
		int id = ((TestAction) list.get(i)).getId();
		String question = ((TestAction) list.get(i)).getQuestion();
		}

		System.out.println(id);
		System.out.println(question);

		//DBとの接続を閉じる
		em.close();

		return SUCCESS;
	}
}
