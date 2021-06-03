package inlog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Gebruiker {
    private String gebruikersNaam;
    private String wachtWoord;
    private ArrayList<Gebruiker> allGebruikers = new ArrayList<>();
    private Gebruiker currentUser;

    public Gebruiker(String gebruikersNaam, String wachtWoord) {
        this.gebruikersNaam = gebruikersNaam;
        this.wachtWoord = wachtWoord;
    }

    public void setLogInButton() throws IOException {
        /*String user = getGebruikernaam();
        String pw = getWachtwoord();*/
        Path pad = Path.of("inlogGegevens.txt");
        List<String> alleRegels = Files.readAllLines(pad);
        for (String regel : alleRegels) {
            String[] parts = regel.split(":");
            String username = parts[0];
            String wachtwoord = parts[1];
           /* if(user.equals(username)&& pw.equals(wachtwoord)){
                setCurrentUser();
            }*/
        }
        /*errorAlert.setHeaderText("Error");
        errorAlert.setContentText("Gebruikersnaam of wachtwoord incorrect.");
        errorAlert.show();*/
    }

    private void setCurrentUser() {
        /*String pw = passwordField.getText();
        for (Gebruiker user : allGebruikers){
            if (pw.equals(user.getWachtwoord())){
                currentUser = user;
            }*/
    }
}
