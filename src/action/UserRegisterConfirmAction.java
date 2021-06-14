package action;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class UserRegisterConfirmAction extends ActionSupport{

	@Getter
	@Setter
	private String user_name;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String admin;

	@Getter
	@Setter
	private String passwordconfirm;

	@Getter
	@Setter
	private String error_message_un;

	@Getter
	@Setter
	private String error_message_pw;

	public String execute() {
		String ret = ERROR;

		if(user_name == null | user_name == "") {
			this.error_message_un = "ユーザー名を入力してください。";
			return ret;
		}

		if(password == null | password == "") {
			this.error_message_pw = "パスワードを入力してください。";
			return ret;
		}

		if(!user_name.matches("^[A-Za-z0-9]+$")) {
			this.error_message_un = "ユーザー名は半角英数字で入力してください。";
			return ret;
		}

		if (!password.matches("^[A-Za-z0-9]+$")) {
			this.error_message_pw = "パスワードは半角英数字のみ8文字以上で入力してください。";
			return ret;
		}

		if (password.length() < 8) {
			this.error_message_pw = "パスワードは半角英数字のみ8文字以上で入力してください。";
			return ret;
		}

//		if (passwordconfirm != password) {
//			this.error_message_pw = "パスワードとパスワード確認は一致する必要があります。";
//			return ret;
//		}

		System.out.println(admin);
		ret = SUCCESS;
		return ret;
	}
}
