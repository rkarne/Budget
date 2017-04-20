/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Controller.UserController;
import javax.faces.bean.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojo.Userdetails;

/**
 * REST Web Service
 *
 * @author c0689497
 */
@Path("/users")
@ApplicationScoped
public class UserService {

UserController us = new UserController();
    /**
     * Creates a new instance of GenericResource
     */
    public UserService() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
 @Produces("application/json")
     public Response getAllJson() {
         JsonArrayBuilder json = Json.createArrayBuilder();
        for (Userdetails m : us.getUsers()) {
            json.add(m.convertToJson());
        }
        return Response.ok(json.build().toString()).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
