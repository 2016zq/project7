package project7;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private String name;
	List<Poker> handcard = new ArrayList<Poker>();
	public Player() {}
	public Player(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
