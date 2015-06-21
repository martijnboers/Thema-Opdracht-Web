package atd.domein;

public class AccountWrapper {
	private int id;
	private String naam;
	private String username;
	private Privilege priv;
	
	public AccountWrapper(int id, String naam, String username, Privilege priv){
		this.id = id;
		this.naam = naam;
		this.username = username;
		this.priv = priv;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public String getUsername() {
		return username;
	}

	public Privilege getPriv() {
		return priv;
	}
}
