package atd.domein;

import java.io.Serializable;

public class Auto implements Serializable{
    private String kenteken;
    private String merk;
    private String type;

    public Auto(String kenteken, String merk, String type)
    {
        this.kenteken = kenteken;
        this.merk = merk;
        this.type = type;
    }

    public String toString()
    {
        return "auto: " + merk + " " + type + " met kenteken: " + kenteken;
    }
    public String getKenteken(){
    	return kenteken;
    }
}
