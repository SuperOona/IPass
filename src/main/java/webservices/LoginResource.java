package webservices;

import inlog.Filter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Key;
import java.security.Principal;
import java.util.HashMap;

@Path("login")
public class LoginResource {
    private static Key key = MacProvider.generateKey();
    public static Key getKey() { return key; }

    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response whoAmI(@Context SecurityContext ctx){
        Principal loggedInUser = ctx.getUserPrincipal();
        if(loggedInUser == null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        HashMap<String, String> response = new HashMap<>();
        response.put("user", loggedInUser.getName());

        return Response.ok(response).build();
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("gebruikersnaam") String username, @FormParam("wachtwoord") String password){
        HashMap<String, String> response = new HashMap<>();

        if(username.equals("tom") && password.equals("tom")){
            response.put("user", username);
            String token = Jwts.builder()
                    .setSubject("tom")
                    .signWith(SignatureAlgorithm.HS512, Filter.KEY)
                    .compact();
            response.put("token", token);
            return Response.ok(response).build();
        }

        response.put("error", "Invalid credentials");
        return Response.status(401).entity(response).build();
    }
}
