package ulaval.glo2003;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("users")
public class UserResource {
    @POST
    public Response createUser(UserRequest request) {
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllUsers() {
        return Response.ok().build();
    }

    @GET
    @Path("{userId}")
    public Response getUser(@PathParam("userId") String userIdParam) {
        return Response.ok().build();
    }
}
