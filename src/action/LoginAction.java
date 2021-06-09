package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import util.DBUtil;

public class LoginAction extends ActionSupport {

    @Getter
    @Setter
	private int id;//jspファイルから受け取る値の定義　※jspでの定義と変数名を合わせる

    @Getter
    @Setter
	private String password;//jspファイルから受け取る値の定義　※jspでの定義と変数名を合わせる

    @Getter
    @Setter
	private byte admin;

    @Getter
    @Setter
	private String name;

	@Override
	public String execute() throws SQLException{//ActionSupportクラスのexecuteメソッドのオーバーライド
		String ret = ERROR;//戻り値retに初期値ERRORを代入    ERRORはActionSupportが実装しているActionインターフェースに定義されている定数ERROR=“error”

		//DB接続
		EntityManager em = DBUtil.createEntityManager();

		//DBからユーザー情報を取得
		List<User> users = em.createNamedQuery("findAllUserInfo", User.class).getResultList();

		//入力パスワードのハッシュ化
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String pw = encoder.encode(password);

		//DBとの接続を閉じる
		em.close();

		if(password != null && id != 0) {
			for(int i = 0; i < users.size(); i++) {
				int qid = users.get(i).getId();//dao.selectでデータベースにアクセス(login.jspから送られたname、passwordを引数)して、結果をdtoに代入
				if(id == qid) {//login.jspから送られてきたidとデータベースから取得したidが正しい場合、
					if(password.equals(users.get(i).getPassword())){//login.jspから送られてきたpasswordとデータベースから取得したpasswordが正しい場合、
						ret = SUCCESS;//戻り値retにSUCCESSを代入する　SUCCESSはActionSupportが実装しているActionインターフェースに定義されている定数SUCCESS=“success”
						admin = users.get(i).getAdmin_flag();
						name = users.get(i).getName();
						}
					}
				}
			}
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		session.put("user_id", id);
		session.put("password", password);
		session.put("user_admin", admin);
		session.put("user_name", name);

		return ret;//actionの結果に"error"か"success"を代入　struts.xmlで次に遷移するページを判断する。
	}
}
