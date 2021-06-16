package inlog;

import java.security.Principal;
import java.util.ArrayList;

public class Gebruiker implements Principal {
    private String gebruikersNaam;
    private String wachtWoord;
    private ArrayList<Gebruiker> allGebruikers = new ArrayList<>();
    private Gebruiker currentUser;

    public Gebruiker(String username) {
        this.gebruikersNaam = username;
    }

   public void setWachtWoord(String wachtWoord){
        this.wachtWoord = wachtWoord;
   }

    @Override
    public String getName() {
        return null;
    }
}
