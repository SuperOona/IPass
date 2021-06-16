package inlog;

import javax.ws.rs.core.SecurityContext;

public class CustomSecurity implements SecurityContext {
    private Gebruiker user;

    public CustomSecurity(Gebruiker user){
        this.user = user;
    }

    @Override
    public Gebruiker getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String s) {
        if(s != null && s.equals("editor")){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}