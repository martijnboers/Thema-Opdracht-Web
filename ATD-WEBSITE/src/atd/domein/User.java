package atd.domein;

public class User {
	private int id;
	private String naam;
	private String username;
	private Privilege priv;
	
	public User(int id, String naam, String username, Privilege priv){
		this.setId(id);
		this.naam = naam;
		this.username = username;
		this.priv = priv;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Privilege getPriv() {
		return priv;
	}

	public void setPriv(Privilege priv) {
		this.priv = priv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
