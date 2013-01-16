package com.jcheype.codestory2013.resources;

import com.sun.jersey.api.NotFoundException;
import org.springframework.stereotype.Component;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 24/08/12
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */

@Component
@Path("/")
public class ServerResource {
    public static final String ROOT_PATH = new File("web").getAbsolutePath();

    @GET
    public Response index() {
        return Response.temporaryRedirect(URI.create("index.html")).build();
    }

    @GET
    @Path("{path : .*}")
    public Response staticResource(@PathParam("path") String path) {
        File file = new File(ROOT_PATH, path);
        checkPath(file);
        String mimeType = new MimetypesFileTypeMap().getContentType(file);
        return Response.ok(file, mimeType).lastModified(new Date()).build();
    }

    private void checkPath(File file) throws NotFoundException {
        try {
            if (!file.getCanonicalPath().startsWith(ROOT_PATH)) {
                throw new NotFoundException();
            }
        } catch (IOException e) {
            throw new NotFoundException();
        }
    }
}
