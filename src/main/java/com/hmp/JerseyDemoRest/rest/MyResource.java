package com.hmp.JerseyDemoRest.rest;


import com.hmp.JerseyDemoRest.Bean.User;
import com.hmp.JerseyDemoRest.dao.UserDao;
import com.hmp.JerseyDemoRest.service.UserRepo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

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
        User a = new User();
        List<User> userList = u.setUserInfo(a);
        return userList;
    }
    @Path("postDB")
    @POST
    public Response postData(@FormParam("id") int id, @FormParam("firstname")String fname,
                             @FormParam("lastname")String lname, @FormParam("username")String username,
                             @FormParam("email")String email, @FormParam("gender")String gender){
User user = new User();
user.setIdNo(id);
user.setUserName(username);
user.setGender(gender);
user.setFirstName(fname);
user.setUserName(lname);
user.setEmail(email);
UserDao userDao = new UserDao();
try{
userDao.getConnection(user);
    return Response.status(200).entity(user).build();
}
catch (Exception e ){
    return Response.serverError().entity("Error occurred during post operation").build();
}


    }
    @Path("postpostman")
      @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postDBPostman(User user){
        UserDao userDao = new UserDao();
        userDao.getConnection(user);
        return Response.ok().entity(user).build();
    }
}



