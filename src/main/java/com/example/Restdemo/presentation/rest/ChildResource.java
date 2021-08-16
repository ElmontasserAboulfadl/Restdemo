package com.example.Restdemo.presentation.rest;


import com.example.Restdemo.datalayer.entities.trans.Child;
import com.example.Restdemo.services.FamilyProcessor;
import io.swagger.annotations.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Child resource")
@Path("/Restdemo")
public class ChildResource {


    private static FamilyProcessor familyProcessor = new FamilyProcessor();


    @Path("/child")
    @GET
    @ApiOperation("Get all children")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Child> getAllChildren() {
         return familyProcessor.getChildren();
    }

    @Path("/child/{name}")
    @GET
    @ApiOperation("Get a child")
    @Produces({ MediaType.APPLICATION_JSON })
    public Child getChild(@ApiParam("name of the child") @PathParam("name") String name) {
        return familyProcessor.getChild(name).orElse(null);
    }

    @Path("/child")
    @POST
    @ApiOperation("Insert a  child")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 200, message = "Child created")})
    public String addChild(@ApiParam("Child to be inserted")  Child child) {
        familyProcessor.createChild(child);
        return "ok";
    }

}
