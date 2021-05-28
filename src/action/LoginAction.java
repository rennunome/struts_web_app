package action;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import util.DBUtil;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	//implements SessionAware

//	private SessionMap<String,Object> sessionMap;
//
//	@Override
//	public void setSession(Map<String, Object> map) {
//
//	    sessionMap = (SessionMap)map;
//	}

	private int id;//jspファイルから受け取る値の定義　※jspでの定義と変数名を合わせる
	private String password;//jspファイルから受け取る値の定義　※jspでの定義と変数名を合わせる

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

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
//						byte admin = users.get(i).getAdminFlag();
//						String name = users.get(i).getName();

						/*セッション情報に追加
						(仮)1
						ActionContext.getContext().getSession().put("login_admin", admin);
						System.out.println((byte)ActionContext.getContext().getSession().get("login_admin"));
						(仮)2
						sessionMap.put("login","true");
						sessionMap.put("user_id", id);
						sessionMap.put("user_admin", admin);
						sessionMap.put("user_name", name);
						 */
						}
					}
				}
			}
		return ret;//actionの結果に"error"か"success"を代入　struts.xmlで次に遷移するページを判断する。
	}
}
