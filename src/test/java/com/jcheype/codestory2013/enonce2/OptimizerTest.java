package com.jcheype.codestory2013.enonce2;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mush
 * Date: 1/18/13
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class OptimizerTest {
    ObjectMapper mapper = new ObjectMapper();
    private String json;


    @Before
    public void setUp() throws Exception {
        json = "[\n" +
                "    { \"VOL\": \"MONAD42\", \"DEPART\": 0, \"DUREE\": 5, \"PRIX\": 10 },\n" +
                "    { \"VOL\": \"META18\", \"DEPART\": 3, \"DUREE\": 7, \"PRIX\": 14 },\n" +
                "    { \"VOL\": \"LEGACY01\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 8 },\n" +
                "    { \"VOL\": \"YAGNI17\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 7 }\n" +
                "]";

    }

    @Test
    public void optimizeTest() throws IOException {
        List<Map> maps = mapper.readValue(json, new TypeReference<List<Map>>() {
        });
        Optimizer optimizer = new Optimizer();
        List<Vol> optimize = optimizer.optimize(Collections.EMPTY_LIST, Vol.fromMaps(maps));
        System.out.println(optimizer.formatString(optimize));
    }
}
