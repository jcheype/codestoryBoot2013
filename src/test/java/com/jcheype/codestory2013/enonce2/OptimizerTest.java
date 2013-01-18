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
        json = "[{\"VOL\": \"AF514\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10}]";

    }

    @Test
    public void optimizeTest() throws IOException {
        List<Map> maps = mapper.readValue(json, new TypeReference<List<Map>>() {
        });
        Optimizer optimizer = new Optimizer();
        List<Vol> optimize = optimizer.optimize(Collections.EMPTY_LIST, Vol.fromMaps(maps));
        System.out.println(mapper.writeValueAsString(optimizer.format(optimize)));
    }
}
