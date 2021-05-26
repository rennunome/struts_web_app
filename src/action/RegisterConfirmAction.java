package action;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class RegisterConfirmAction extends ActionSupport{

	@Getter
	@Setter
	private String question;
	@Getter
	@Setter
	private String answer[];

	@Getter
	@Setter
	private String error_message_question = "";
	@Getter
	@Setter
	private String error_message_answer = "";

	public String execute(){
		String ret = ERROR;

		if(question == null | question == "") {
			error_message_question = "問題を入力してください。";
		}

		if(answer == null) {
			error_message_answer = "答えを入力してください。";
		}

		if(question != null && question.length() > 500) {
			error_message_question = "500文字以上は入力できません。";
			return ERROR;
		}

		if (answer != null) {
			for (int i = 0; i < answer.length; i++) {
				if (answer[i] != null && answer[i].length() > 200) {
					error_message_answer = "200文字以上は入力できません。";
					return ERROR;
				}
			}
		}
		ret = SUCCESS;
		return ret;
	}
}
