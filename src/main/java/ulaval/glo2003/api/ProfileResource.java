package ulaval.glo2003.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import ulaval.glo2003.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Path("profiles")
public class ProfileResource {
    private final List<User> users;

    public ProfileResource(List<User> users) {
        this.users = users;
    }

    @GET
    public Response getProfiles() {
        List<UserResponse> responses = this.users
                .stream()
                .map(user -> new UserResponse(user.getId(), user.getName()))
                .collect(Collectors.toList());

        return Response.ok(responses).build();
    }
}
