package inlog;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;
import java.security.Key;

public class Filter implements ContainerRequestFilter {
    //Key key = MacProvider.generateKey(); makkelijk
    public static final Key KEY = new SecretKeySpec(
            "Dit is best een hoop gedoe om een tekst lang genoeg te typen om voldoende bytes voor mijn key te hebben".getBytes()
            , SignatureAlgorithm.HS512.getJcaName()); //stabiel: gejat uit de jjwt io source code


    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authHeader = containerRequestContext.getHeaderString("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer ".length()).trim();
            JwtParser parser = Jwts.parser().setSigningKey(KEY);
            String username = parser.parseClaimsJws(token).getBody().getSubject();
            containerRequestContext.setSecurityContext(new CustomSecurity(new Gebruiker(username)));
        }
    }
}
