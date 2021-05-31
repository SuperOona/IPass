package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StatusResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus(){
        return Response.ok().build();
    }
}
