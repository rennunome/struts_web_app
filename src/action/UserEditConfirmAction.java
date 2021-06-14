package action;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class UserEditConfirmAction extends ActionSupport{

	@Getter
	@Setter
	private int user_id;

	@Getter
	@Setter
	private String user_name;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String passwordconfirm;

	@Getter
	@Setter
	private boolean admin_flag;

	@Getter
	@Setter
	private byte admin;

	@Getter
	@Setter
	private String error_message_pw = "";

	public String execute() {

		if(password == null | password == "") {
			this.error_message_pw = "パスワードを入力してください。";
			return ERROR;
		}

		if (!password.matches("^[A-Za-z0-9]+$")) {
			this.error_message_pw = "パスワードは半角英数字のみ8文字以上で入力してください。";
			return ERROR;
		}

		if (password.length() < 8) {
			this.error_message_pw = "パスワードは半角英数字のみ8文字以上で入力してください。";
			return ERROR;
		}

		if (passwordconfirm != password) {
			this.error_message_pw = "パスワードとパスワード確認は一致する必要があります。";
			return ERROR;
		}

		if(admin_flag == true) {
			admin = 1;
		} else {
			admin = 0;
		}

		return SUCCESS;
	}
}
