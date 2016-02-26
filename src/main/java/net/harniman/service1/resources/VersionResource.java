package net.harniman.service1.resources;

import java.awt.PageAttributes.MediaType;

//import org.springframework.beans.factory.annotation.Autowired;

@Path("/version")

@Produces(MediaType.APPLICATION_JSON)
public class VersionResource {
    private final String version;

    public VersionResource(String version) {
        this.version = version;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public String getVersion(){
        return version;
    }

}