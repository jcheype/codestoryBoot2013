package com.jcheype.codestory2013.resources;

import com.google.common.io.Files;
import com.jcheype.webServer.Request;
import com.jcheype.webServer.Response;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.springframework.stereotype.Component;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public void index(Request request, Response response) {
        DefaultHttpResponse httpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(307));

        String host = request.getHeader("Host");
        httpResponse.setHeader("Location", "http://"+host+"/index.html");

        response.write(httpResponse);
    }

    @GET
    @Path("{path : .*}")
    public void staticResource(@PathParam("path") String path, Response response) throws Exception {
        File file = new File(ROOT_PATH, path);
        checkPath(file);
        String mimeType = new MimetypesFileTypeMap().getContentType(file);

        DefaultHttpResponse httpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(200));
        httpResponse.setHeader(HttpHeaders.Names.CONTENT_TYPE, mimeType);
        httpResponse.setHeader(HttpHeaders.Names.CONTENT_LENGTH, file.length());

        httpResponse.setContent(ChannelBuffers.copiedBuffer(Files.toByteArray(file)));
        response.write(httpResponse);
    }

    private void checkPath(File file) throws Exception {
        try {
            if (!file.getCanonicalPath().startsWith(ROOT_PATH)) {
                throw new Exception();
            }
        } catch (IOException e) {
            throw new Exception();
        }
    }
}
