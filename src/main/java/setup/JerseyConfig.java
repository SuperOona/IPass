package setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/oonaIsCool")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() { packages("webservices");}
}
