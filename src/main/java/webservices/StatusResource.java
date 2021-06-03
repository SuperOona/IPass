package webservices;

import inlog.Status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Path("/oonaIsCool/status")
public class StatusResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus() {
        /*java.nio.file.Path pad = java.nio.file.Path.of("status.txt");
        List<String> alleRegels = Files.readAllLines(pad);
        for (String regel : alleRegels) {
            String[] parts = regel.split(":");
            String jaNee = parts[0];
            String reden = parts[1];
            }*/
        return Response.ok(Status.getAlleStatus()).build();

    }

}
