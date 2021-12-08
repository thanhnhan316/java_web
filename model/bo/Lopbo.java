package bo;

import java.util.ArrayList;

import bean.Lopbean;
import dao.Lopdao;

public class Lopbo {
	Lopdao ldao = new Lopdao();
	
	public ArrayList<Lopbean> getLop(){
		return ldao.getLop();
	}

}
