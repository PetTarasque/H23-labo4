package ulaval.glo2003.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class GlobalExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        exception.printStackTrace();
        return Response.status(500).entity("Unknown error").build();
    }
}
