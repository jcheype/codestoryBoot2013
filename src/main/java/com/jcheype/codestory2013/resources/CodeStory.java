package com.jcheype.codestory2013.resources;

import com.google.common.io.Files;
import com.jcheype.codestory2013.enonce1.Enonce1;
import com.jcheype.codestory2013.enonce2.Optimizer;
import com.jcheype.codestory2013.enonce2.Vol;
import com.jcheype.codestory2013.enonce2.VolComparator;
import com.jcheype.codestory2013.simpleCalc.SimpleCalc;
import com.jcheype.webServer.Request;
import com.jcheype.webServer.Response;
import com.jcheype.webServer.ResponseBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
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
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

        else if ("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if ("Est ce que tu reponds toujours oui(OUI/NON)".equals(request.getParam("q")))
            return "NON";
        else if ("As tu bien recu le premier enonce(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if ("1,0000000000000000000000000000000000000000000000001*1,0000000000000000000000000000000000000000000000001".equals(request.getParam("q")))
            return "1,00000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000001";
        else if ("((1,1 2) 3,14 4 (5 6 7) (8 9 10)*4267387833344334647677634)/2*553344300034334349999000".equals(request.getParam("q")))
            return "31878018903828899277492024491376690701584023926880";
        else if ("As tu passe une bonne nuit malgre les bugs de l etape precedente(PAS_TOP/BOF/QUELS_BUGS)".equals(request.getParam("q")))
            return "QUELS_BUGS";
        else if ("As tu bien recu le second enonce(OUI/NON)".equals(request.getParam("q")))
            return "OUI";
        else if ("As tu copie le code de ndeloof(OUI/NON/JE_SUIS_NICOLAS)".equals(request.getParam("q")))
            return "NON";
        else if ("Souhaites-tu-participer-a-la-suite-de-Code-Story(OUI/NON)".equals(request.getParam("q")))
            return "OUI";

        Number calc = SimpleCalc.calc(request.getParam("q"));
        if (calc != null) {
            DecimalFormat df = new DecimalFormat();
            df.setParseIntegerOnly(true);
            df.setGroupingUsed(false);
            df.setMaximumIntegerDigits(200);
            return df.format(calc);
        }

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

    @Path("/enonce/:id")
    @POST
    public void getPost(String id, Request request, Response response) throws IOException {
        String content = request.content;

        logger.debug("content: " + content);
        File codestory = File.createTempFile("codestory_" + id + "_", ".md");
        logger.debug("file content: " + codestory.getPath());
        Files.write(content, codestory, Charset.forName("UTF-8"));

        response.write(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(201)));
    }

    @Path("/jajascript/optimize")
    @POST
    public void enonce2Post(Request request, Response response) throws IOException {
        String content = request.content;

        logger.debug("content: " + content);

        List<Map> maps = mapper.readValue(content, new TypeReference<List<Map>>() {
        });
        Optimizer optimizer = new Optimizer();
        List<Vol> vols = Vol.fromMaps(maps);
        Collections.sort(vols, new VolComparator());
        logger.debug("vols: {}", vols);

        List<Vol> optimize = optimizer.optimize4(vols);

        String data = optimizer.formatString(optimize);
        logger.debug("result: {}", data);

        HttpResponse httpResponse = new ResponseBuilder().setVersion(HttpVersion.HTTP_1_0).setStatus(HttpResponseStatus.valueOf(201))
                .setContent(data, Charset.forName("UTF-8"))
                .setHeader("Content-type", "application/json; charset=UTF-8")
                .build();
        response.write(httpResponse);
    }

    @Path("/shutyourfuckinggob")
    @GET
    public void shutyourfuckinggob() {
        System.exit(0);
    }
}
