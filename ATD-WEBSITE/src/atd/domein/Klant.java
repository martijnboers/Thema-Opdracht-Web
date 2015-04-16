package atd.domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Klant implements Serializable{
    private Auto deAuto;
    private String email;
    private String postcode;
    private String volledigeNaam;
    private String username;
    private ArrayList<Afspraak> alleAfspraken;
    private Privilege priv;

    public Klant(String volledigeNaam, String username, String postcode, String email, Auto deAuto, Privilege priv)
    {
        this.postcode = postcode;
        this.volledigeNaam = volledigeNaam;
        this.username = username;
        this.deAuto = deAuto;
        this.email = email;
        this.priv = priv;
        alleAfspraken = new ArrayList<Afspraak>();
    }
    public Privilege getPriv(){
    	return priv;
    }
    public boolean onderhoud() //Hier wordt gekeken of er onderhoud nodig is
    {
        boolean b = false;
        Afspraak a= laatsteOnderhoudsAfspraak();
        Calendar nu = Calendar.getInstance();
        int maandNu = nu.get(Calendar.MONTH) + 1;

        if(maandNu < 6 ) //Als het huidige jaar nog geen 6 maanden is gepasseerd, komen er 12 maanden bij zodat er alsnog kan worden gekeken of er 6 maanden tussen de laatste onderhoudsafspraak en de huidige datum zitten.
        {                //evt zou er ook nog gekeken kunnen worden hoeveel verschil er tussen de jaren zitten van de laatste afspraak en nu, maar momenteel gaan de afspraken alleen over vorig jaar en dit jaar.
            maandNu += 12;
        }

        if((maandNu - a.getMaand()) == 6)
        {
            b = true;
        }

        return b;
    }

    public boolean herinnering() //Hier wordt gekeken of er een herinneringsbrief nodig is
    {
        boolean b = false;

        Collections.sort(alleAfspraken, new Comparator<Afspraak>() { //Om de laatste afspraak te kunnen achterhalen worden de Afspraken eerst op data gesorteerd met deze custom Comparator
            @Override
            public int compare(Afspraak a0, Afspraak a1) {
                return a0.getDatum().compareTo(a1.getDatum());
            }});

        Afspraak laatsteAfspraak = alleAfspraken.get(alleAfspraken.size()-1); //Vervolgens wordt de laatste Afspraak in de ArrayList opgehaald
        int laatsteAfspraakMaand = laatsteAfspraak.getMaand();
        Calendar nu = Calendar.getInstance();
        int maandNu = nu.get(Calendar.MONTH) + 1;

        if(maandNu < 2) //Hier gebeurd hetzelfde als bij onderhoud(), als de maanden van het huidige jaar de 2 nog niet gepasseerd zijn komen er 12 bij zodat er alsnog gekeken kan worden of er 2 maanden verschil is
        {
            maandNu += 12;

        }


        if(alleAfspraken.size()> 5 && (maandNu - laatsteAfspraakMaand) >= 2) //Naast dat het verschil wordt bekeken wordt er ook gekeken naar hoe frequent de Klant is langs geweest
        {
            b = true;
        }

        return b;


    }

    public void voegAfspraakToe(Afspraak a)
    {
        alleAfspraken.add(a);
    }
    public Afspraak laatsteOnderhoudsAfspraak()//In deze methode worden de onderhoudsafspraken gescheiden van de andere afspraken en vervolgens gesorteerd met ook weer een custom Comparator, om te kijken wat de laatste onderhoudsafspraak was
    {

        ArrayList<Afspraak> onderhoudsAfspraken = new ArrayList<Afspraak>();
        Afspraak laatsteAfspraak = null;

        for(Afspraak a : alleAfspraken)
        {
            if(a.getType().equals("onderhoud"))
            {
                onderhoudsAfspraken.add(a);
            }
        }

        Collections.sort(onderhoudsAfspraken, new Comparator<Afspraak>() {
            @Override
            public int compare(Afspraak a0, Afspraak a1) {
                return a0.getDatum().compareTo(a1.getDatum());
            }
        });

        laatsteAfspraak = onderhoudsAfspraken.get(onderhoudsAfspraken.size()-1);

        return laatsteAfspraak;
    }

    public String toString()
    {
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
}
