package org.bitsly.bud.base.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public interface RestService {
    @GET
    @Path("ping")
    String ping();
}
