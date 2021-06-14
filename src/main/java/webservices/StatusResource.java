package webservices;

import inlog.Status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Path("/status")
public class StatusResource {
    @GET // naar website
    @Produces(MediaType.APPLICATION_JSON)
    public Response setStatus() {
        return Response.ok(Status.getAlleStatus()).build();
    }


    @POST //naar back-end
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusHome(@FormParam("jaNee") String jaNee, @FormParam("reden") String reden){
        Status stat = new Status(jaNee, reden);
        stat.voegStatusToe(stat);
        return Response.ok("Status verwerkt").build();
    }

}
