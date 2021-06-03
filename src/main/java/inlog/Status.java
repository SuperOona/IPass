package inlog;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class Status {
    private String jaNee;
    private String status;
    private Gebruiker gebruiker;
    private LocalDate date;
    private static List<Status> oudStatus;


    public Status(String jaNee, String reden) {
        this.jaNee = jaNee;
        this.status = reden;
        this.date = LocalDate.now();
    }

    public void readFile() throws IOException {
        Path pad = Path.of("oudStatus.txt");
        List<String> alleRegels = Files.readAllLines(pad);
        for (String regel : alleRegels) {
            String[] parts = regel.split(":");
            String jaNee = parts[0];
            String reden = parts[1];
            Status status = new Status(jaNee, reden);
            oudStatus.add(status);
        }
    }

    public static List<Status> getAllStatus(){
        return oudStatus;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus() {
        return Response.ok(Status.getAllStatus()).build();

    }
}


