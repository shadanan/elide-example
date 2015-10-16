package com.yahoo.elide.example.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by shad on 15-10-15.
 */
@Path("/ping")
public class Ping {
    @GET
    public Response getPing() {
        return Response.ok("pong").build();
    }
}
