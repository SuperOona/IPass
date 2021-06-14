package inlog;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Status {
    private static Status deStatus;
    private String jaNee;
    private String status;
    private Gebruiker gebruiker;
    private LocalDate date;
    private static final ArrayList<Status> alleStatus = new ArrayList<>();


    public Status(String jaNee, String reden) {
        this.jaNee = jaNee;
        this.status = reden;
        this.date = LocalDate.now();
    }

    public static void setDeStatus(Status deStatus){
        Status.deStatus = deStatus;
    }

    public static ArrayList<Status> getAlleStatus(){
        return alleStatus;
    }

    public void voegStatusToe(Status stat){
        alleStatus.add(stat);
    }



}


