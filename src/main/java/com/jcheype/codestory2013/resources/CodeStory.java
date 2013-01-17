package com.jcheype.codestory2013.resources;

import com.google.common.io.Files;
import com.jcheype.codestory2013.enonce1.Enonce1;
import com.jcheype.webServer.Request;
import com.jcheype.webServer.Response;
import com.jcheype.webServer.ResponseBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 04/01/13
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */

@Component
public class CodeStory {
    Enonce1 enonce1 = new Enonce1(100);

    ObjectMapper mapper = new ObjectMapper();

    Logger logger = LoggerFactory.getLogger(CodeStory.class);

    @Path("/")
    @GET
    public String getQuery(Request request, Response response) {
        logger.debug("request: " + request.getParam("q"));
        if ("Quelle est ton adresse email".equals(request.getParam("q")))
            return "cheype@gmail.com";
        else if ("Es tu heureux de participer(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if ("Es tu abonne a la mailing list(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if ("Es tu pret a recevoir une enonce1 au format markdown par http post(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if ("Est ce que tu reponds toujours oui(OUI/NON)".equals(request.getParam("q")))
            return "NON";
        else if ("As tu bien recu le premier enonce(OUI/NON)".equals(request.getParam("q")))
            return "OUI";


        HttpResponse build = new ResponseBuilder()
                .setStatus(HttpResponseStatus.NO_CONTENT)
                .build();


        response.write(build);
        return null;
    }

    @Path("/scalaskel/change/:value")
    @GET
    public void enonce1Get(String value, Request request, Response response) throws IOException {
        int i = Integer.parseInt(value);

        Collection decompose = enonce1.decompose(i);


        HttpResponse httpResponse = new ResponseBuilder().setStatus(HttpResponseStatus.valueOf(200))
                .setContent(mapper.writeValueAsBytes(decompose))
                .setHeader("Content-type", "application/json; charset=UTF-8")
                .build();
        response.write(httpResponse);
    }

    @Path("/enonce1/:id")
    @POST
    public void getPost(String id, Request request, Response response) throws IOException {
        String content = request.content;

        logger.debug("content: " + content);
        File codestory = File.createTempFile("codestory_" + id + "_", ".md");
        logger.debug("file content: " + codestory.getPath());
        Files.write(content, codestory, Charset.forName("UTF-8"));

        response.write(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(201)));
    }

    @Path("/shutyourfuckinggob")
    @GET
    public void shutyourfuckinggob() {
        System.exit(0);
    }
}
