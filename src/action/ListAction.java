package action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import entity.Answer;
import entity.Question;
import util.DBUtil;

public class ListAction extends ActionSupport{

	public String excute(Action action, ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response){
		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//DBからユーザー情報を取得
		List<Question> questions = em.createNamedQuery("findAllQuestionInfo", Question.class).getResultList();
		List<Answer> answers = em.createNamedQuery("findAllAnswerInfo", Answer.class).getResultList();

		//DBとの接続を閉じる
		em.close();

		request.setAttribute("q_list", questions);
		request.setAttribute("ca_list", answers);

	    return SUCCESS;
	}
}
