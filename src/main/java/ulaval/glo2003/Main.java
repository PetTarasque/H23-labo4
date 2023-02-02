package ulaval.glo2003;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import ulaval.glo2003.api.GlobalExceptionMapper;
import ulaval.glo2003.api.ProfileResource;
import ulaval.glo2003.api.UserResource;
import ulaval.glo2003.domain.User;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();

        UserResource userResource = new UserResource(users);
        ProfileResource profileResource = new ProfileResource(users);

        GlobalExceptionMapper globalExceptionMapper = new GlobalExceptionMapper();

        ResourceConfig resourceConfig = new ResourceConfig()
                .register(userResource)
                .register(profileResource)
                .register(globalExceptionMapper);
        URI uri = URI.create("http://localhost:8080/");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig);
        server.start();
    }
}
