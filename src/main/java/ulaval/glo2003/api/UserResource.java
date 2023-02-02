package ulaval.glo2003.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import ulaval.glo2003.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Path("users")
public class UserResource {
    private final List<User> users;

    public UserResource(List<User> users) {
        this.users = users;
    }

    @POST
    public Response createUser(UserRequest request) {
        User user = new User(request.name);
        users.add(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllUsers() {
        List<UserResponse> userResponses = this.users
                .stream()
                .map(user -> new UserResponse(user.getId(), user.getName()))
                .collect(Collectors.toList());

        return Response.ok(userResponses).build();
    }

    @GET
    @Path("{userId}")
    public Response getUser(@PathParam("userId") String userId) {
        User foundUser = this.users
                .stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found."));

        UserResponse response = new UserResponse(foundUser.getId(), foundUser.getName());

        return Response.ok(response).build();
    }
}
