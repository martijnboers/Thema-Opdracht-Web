package atd.domein;

import java.io.Serializable;

public class Auto {
	private int id;
	private String kenteken;
	private String merk;
	private String type;

	public Auto(int id, String kenteken, String merk, String type) {
		this.kenteken = kenteken;
		this.setMerk(merk);
		this.setType(type);
	}

	public String getKenteken() {
		return kenteken;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
}
