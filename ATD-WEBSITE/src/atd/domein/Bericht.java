package atd.domein;

import atd.domein.User;

public class Bericht {
	private String bericht;
	private User owner;
	private String date;
	
	public Bericht(String bericht, String date, User owner){
		this.date = date;
		this.setBericht(bericht);
		this.setOwner(owner);
	}

	public String getBericht() {
		return bericht;
	}

	public void setBericht(String bericht) {
		this.bericht = bericht;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getDate() {
		return date;
	}
}
