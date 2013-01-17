package com.jcheype.codestory2013.resources;

import com.google.common.io.Files;
import com.jcheype.webServer.Request;
import com.jcheype.webServer.Response;
import com.jcheype.webServer.ResponseBuilder;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 04/01/13
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */

@Component
public class CodeStory {
    Logger logger = LoggerFactory.getLogger(CodeStory.class);
    @Path("/")
    @GET
    public String getQuery(Request request, Response response){
        logger.debug("request: " + request.getParam("q"));
        if("Quelle est ton adresse email".equals(request.getParam("q")))
            return "cheype@gmail.com";
        else if("Es tu heureux de participer(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if("Es tu abonne a la mailing list(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if("Est ce que tu reponds toujours oui(OUI/NON)".equals(request.getParam("q")))
            return "NON";


        HttpResponse build = new ResponseBuilder()
                .setStatus(HttpResponseStatus.NO_CONTENT)
                .build();


        response.write(build);
        return null;
    }

    @Path("/enonce/:id")
    @GET
    public void getPost(String id, Request request, Response response) throws IOException {
        String content = request.content;

        logger.debug("content: " + content);
        File codestory = File.createTempFile("codestory_"+ id +"_",".md");
        logger.debug("file content: " + codestory.getPath());
        Files.write(content, codestory, Charset.forName("UTF-8"));


        response.write(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(201)));
    }

    @Path("/shutyourfuckinggob")
    @GET
    public void shutyourfuckinggob(){
        System.exit(0);
    }
}
