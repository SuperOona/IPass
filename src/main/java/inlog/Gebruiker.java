package inlog;

public class Gebruiker {
    private String gebruikersNaam;
    private String wachtWoord;

    public Gebruiker (String gebruikersNaam, String wachtWoord){
        this.gebruikersNaam = gebruikersNaam;
        this.wachtWoord = wachtWoord;
    }


    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public String getWachtWoord() {
        return wachtWoord;
    }

    public void setWachtWoord(String wachtWoord) {
        this.wachtWoord = wachtWoord;
    }
}
