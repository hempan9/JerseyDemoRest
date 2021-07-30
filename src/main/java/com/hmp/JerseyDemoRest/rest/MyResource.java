package com.hmp.JerseyDemoRest.rest;


import com.hmp.JerseyDemoRest.Bean.User;
import com.hmp.JerseyDemoRest.service.UserRepo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("my")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces({MediaType.TEXT_PLAIN })
    public String getIt() {
        return "Got it MAN!";
    }
    @Path("info")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> printUserInfo(){
        UserRepo u = new UserRepo();
        List<User> userList = u.setUserInfo();
        return userList;
    }
}
