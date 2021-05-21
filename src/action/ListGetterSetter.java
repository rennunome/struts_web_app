package action;

import java.util.ArrayList;
import java.util.List;

import entity.Question;

public class ListGetterSetter {

	private List<Question> q;

    public ListGetterSetter(){
        this.q = new ArrayList<Question>();
    }
    public List<Question> getList(){
        return q;
    }
    public void setList(List<Question> q){
        this.q = q;
    }
}
