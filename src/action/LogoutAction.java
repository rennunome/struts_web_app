package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class LogoutAction implements SessionAware{

	private Map<String,Object> userSession;

	@Override
	public void setSession(Map<String, Object> session) {

		userSession = session;
	}

	public String logout(){
	    if(userSession!=null){
	        userSession.clear();
	    }
	    return "success";
	}
}
