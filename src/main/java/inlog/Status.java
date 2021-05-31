package inlog;

import java.time.LocalDate;

public class Status {
    private String status;
    private Gebruiker gebruiker;
    private LocalDate date;
    private

    public Status(String st, Gebruiker gb){
        status = st;
        gebruiker = gb;
        date = LocalDate.now();
    }


}
