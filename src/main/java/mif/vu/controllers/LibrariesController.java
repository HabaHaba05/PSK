package mif.vu.controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/players")
public class LibrariesController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById() {
        return Response.ok("SAUNU").build();
    }
}