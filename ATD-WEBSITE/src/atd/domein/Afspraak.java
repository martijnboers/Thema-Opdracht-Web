package atd.domein;
import java.io.Serializable;
import java.util.Calendar;

public class Afspraak implements Serializable{
    private Type type;
    private Calendar datum;
    private Klant klant;
    private Monteur mon;
    private Calendar beginTijd;
    private Calendar eindTijd;

    /**
     * Maakt een nieuwe afspraak. Let op: Voeg afspraak toe aan afsprakenbestand
     * 
     * @param type	Enum met ONDERHOUD of REPARATIE
     * @param datum	Datum van afspraak
     * @param beginTijd	Begin tijd afspraak
     * @param eindTijd	Eind tijd afspraak
     * @param afspraakBeschrijving	String met omschrijving afspraak
     * @param k1	Klant verbonden aan afspraak
     * @param mon	Monteur verbonden aan afspraak
     */
    public Afspraak(Type type, Calendar datum, Calendar beginTijd, Calendar eindTijd, Klant k1, Monteur mon)
    {
        this.type = type;
        this.datum = datum;
        this.klant = k1;
        this.mon = mon;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
    }

    public Calendar getDatum()
    {
        return datum;
    }

    public int getJaar()
    {
        int jaar = datum.get(Calendar.YEAR);
        return jaar;
    }

    public int getMaand()
    {
        int maand = 1 + datum.get(Calendar.MONTH);
        return maand;
    }

    public int getDag()
    {
        return datum.get(Calendar.DAY_OF_MONTH);
    }

    public Type getType()
    {
        return type;
    }
    
    public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public Calendar getBeginTijd()
    {
        return beginTijd;
    }

    public Calendar getEindTijd()
    {
        return eindTijd;
    }

    public int getBeginUren()
    {
        return beginTijd.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getEindUren()
    {
        return eindTijd.get(Calendar.HOUR_OF_DAY);
    }

    public int getBeginMinuten()
    {
        return beginTijd.get(Calendar.MINUTE);
    }

    public int getEindMinuten()
    {
        return eindTijd.get(Calendar.MINUTE);
    }
    
	public String getLabelPrint(){
    	return datum.get(Calendar.DAY_OF_MONTH) + "-" + datum.get(Calendar.MONTH);
    }
    public int getWeek(){
    	return datum.get(Calendar.WEEK_OF_MONTH);
    }
    public String toString()
    {
		return "";
	}
}
