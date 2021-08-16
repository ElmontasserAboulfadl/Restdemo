package com.example.Restdemo.presentation.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Variant;
import java.util.ArrayList;
import java.util.List;

@Api("Salam in Json")
@Path("/")
public class SalamJsonResource {

    @Path("salam")
    @GET
    @Produces("application/json")
    @ApiOperation("Greet in arabic")
    public List<String> hello() {
        List<String> jsonList = new ArrayList<>();
        jsonList.add("Salam Fairouz");
        jsonList.add("Salam Nadim");
        jsonList.add("Salam Zeinab");
        return jsonList;
    }

    @Path("shalom")
    @GET
    @Produces("application/json")
    @ApiOperation("Greet in hebrew")
    public List<String> shalom() {
        List<String> jsonList = new ArrayList<>();
        jsonList.add("Shalom John");
        jsonList.add("Shalom Lucca");
        return jsonList;
    }
}