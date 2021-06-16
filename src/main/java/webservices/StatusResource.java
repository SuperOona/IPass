package webservices;

import status.Status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;

@Path("/status")
public class StatusResource {
    @GET // naar website
    @Produces(MediaType.APPLICATION_JSON)
    public Response setStatus() {
        ArrayList<Object> alleRegels = new ArrayList<>();
        try {
            alleRegels = Status.read_products();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.ok(alleRegels).build();
    }


    /*@POST //naar back-end
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusHome(@FormParam("jaNee") String jaNee, @FormParam("reden") String reden){
        Status stat = new Status(jaNee, reden);
        stat.voegStatusToe(stat);
        return Response.ok("Status verwerkt").build();
    }*/

}
