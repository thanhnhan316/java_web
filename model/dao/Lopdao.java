package dao;

import java.util.ArrayList;

import bean.Lopbean;

public class Lopdao {
	public ArrayList<Lopbean> getLop(){
		ArrayList<Lopbean> list = new  ArrayList<Lopbean>();
		
		list.add(new Lopbean("K42A", "CNTT K42A"));
		list.add(new Lopbean("K42B", "CNTT K42B"));
		list.add(new Lopbean("K42C", "CNTT K42C"));
		list.add(new Lopbean("K42D", "CNTT K42D"));
		list.add(new Lopbean("K42E", "CNTT K42E"));
		list.add(new Lopbean("K42F", "CNTT K42F"));
		
		return list;
	}
}
