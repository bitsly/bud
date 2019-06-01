package org.bitsly.bud.manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.manager.service.StaffService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/sign/")
@Service
@Slf4j
public class StaffServiceImpl implements StaffService {

    @DELETE
    @Path("/{id:\\d+}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public String signout(@PathParam("id") Long id) {
        log.info("id: {}", id);
        return "<>";
    }
}
