package action;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class EditConfirmAction extends ActionSupport{

	@Getter
	@Setter
	private int questions_id;

	@Getter
	@Setter
	private String question;

	@Getter
	@Setter
	//後にint[]に変更
	private int answers_id;

	@Getter
	@Setter
	//後にString[]に変更
	private String answer;

	@Getter
	@Setter
	private String error_message_question = "";
	@Getter
	@Setter
	private String error_message_answer = "";

	public String execute(){
		String ret = ERROR;

		if(question == null | question == "") {
			this.error_message_question = "問題を入力してください。";
			return ret;
		}

		if(answer == null) {
			this.error_message_answer = "答えを入力してください。";
			return ret;
		}

		if(question != null && question.length() > 500) {
			this.error_message_question = "500文字以上は入力できません。";
			return ret;
		}

		if (answer != null && answer.length() > 200) {
//			for (int i = 0; i < answer.length; i++) {
//				if (answer[i] != null && answer[i].length() > 200) {
					this.error_message_answer = "200文字以上は入力できません。";
					return ret;
				}
//			}
//		}
		ret = SUCCESS;
		return ret;
		}
}
