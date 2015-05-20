package atd.domein;

import java.io.Serializable;
import java.util.ArrayList;

public class Klant implements Serializable {
	private int id;
	private Auto deAuto;
	private String email;
	private String postcode;
	private String volledigeNaam;
	private String username;
	private Privilege priv;

	// TODO: Dit heeft nog heel veel werk nodig

	public Klant(int id, String volledigeNaam, String username, String postcode, String email, Auto deAuto, Privilege priv) {
		this.id = id;
		this.postcode = postcode;
		this.volledigeNaam = volledigeNaam;
		this.username = username;
		this.setDeAuto(deAuto);
		this.email = email;
		this.priv = priv;
	}

	public Privilege getPriv() {
		return priv;
	}

	public String toString() {
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getVolledigeNaam() {
		return volledigeNaam;
	}

	public void setVolledigeNaam(String volledigeNaam) {
		this.volledigeNaam = volledigeNaam;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPriv(Privilege priv) {
		this.priv = priv;
	}

	public Auto getDeAuto() {
		return deAuto;
	}

	public void setDeAuto(Auto deAuto) {
		this.deAuto = deAuto;
	}

	public int getId() {
		return id;
	}
}
