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
        json = "[{\"VOL\":\"0\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":50},\n" +
                "{\"VOL\":\"1\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":2},\n" +
                "{\"VOL\":\"2\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":19},\n" +
                "{\"VOL\":\"3\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":15},\n" +
                "{\"VOL\":\"4\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":19},\n" +
                "{\"VOL\":\"5\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":15},\n" +
                "{\"VOL\":\"6\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":14},\n" +
                "{\"VOL\":\"7\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":5},\n" +
                "{\"VOL\":\"8\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":8},\n" +
                "{\"VOL\":\"9\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":19},\n" +
                "{\"VOL\":\"10\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":2},\n" +
                "{\"VOL\":\"11\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":18},\n" +
                "{\"VOL\":\"12\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":10},\n" +
                "{\"VOL\":\"13\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":7},\n" +
                "{\"VOL\":\"14\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":8},\n" +
                "{\"VOL\":\"15\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":1},\n" +
                "{\"VOL\":\"16\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":15},\n" +
                "{\"VOL\":\"17\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":12},\n" +
                "{\"VOL\":\"18\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":16},\n" +
                "{\"VOL\":\"19\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":10},\n" +
                "{\"VOL\":\"20\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":14},\n" +
                "{\"VOL\":\"21\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":17},\n" +
                "{\"VOL\":\"22\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":6},\n" +
                "{\"VOL\":\"23\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":10},\n" +
                "{\"VOL\":\"24\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":3},\n" +
                "{\"VOL\":\"25\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":17},\n" +
                "{\"VOL\":\"26\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":6},\n" +
                "{\"VOL\":\"27\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":10},\n" +
                "{\"VOL\":\"28\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":5},\n" +
                "{\"VOL\":\"29\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":18},\n" +
                "{\"VOL\":\"30\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":9},\n" +
                "{\"VOL\":\"31\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":8},\n" +
                "{\"VOL\":\"32\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":17},\n" +
                "{\"VOL\":\"33\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":3},\n" +
                "{\"VOL\":\"34\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":14},\n" +
                "{\"VOL\":\"35\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":17},\n" +
                "{\"VOL\":\"36\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":15},\n" +
                "{\"VOL\":\"37\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":13},\n" +
                "{\"VOL\":\"38\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":4},\n" +
                "{\"VOL\":\"39\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":4},\n" +
                "{\"VOL\":\"40\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":3},\n" +
                "{\"VOL\":\"41\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":12},\n" +
                "{\"VOL\":\"42\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":3},\n" +
                "{\"VOL\":\"43\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":8},\n" +
                "{\"VOL\":\"44\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":2},\n" +
                "{\"VOL\":\"45\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":3},\n" +
                "{\"VOL\":\"46\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":4},\n" +
                "{\"VOL\":\"47\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":16},\n" +
                "{\"VOL\":\"48\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":4},\n" +
                "{\"VOL\":\"49\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":6},\n" +
                "{\"VOL\":\"50\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":10},\n" +
                "{\"VOL\":\"51\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":10},\n" +
                "{\"VOL\":\"52\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":11},\n" +
                "{\"VOL\":\"53\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":3},\n" +
                "{\"VOL\":\"54\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":15},\n" +
                "{\"VOL\":\"55\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":7},\n" +
                "{\"VOL\":\"56\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":6},\n" +
                "{\"VOL\":\"57\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":10},\n" +
                "{\"VOL\":\"58\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":9},\n" +
                "{\"VOL\":\"59\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":5},\n" +
                "{\"VOL\":\"60\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":15},\n" +
                "{\"VOL\":\"61\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":16},\n" +
                "{\"VOL\":\"62\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":16},\n" +
                "{\"VOL\":\"63\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":20},\n" +
                "{\"VOL\":\"64\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":16},\n" +
                "{\"VOL\":\"65\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":11},\n" +
                "{\"VOL\":\"66\",\"DEPART\":0,\"DUREE\":9,\"PRIX\":2},\n" +
                "{\"VOL\":\"67\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":15},\n" +
                "{\"VOL\":\"68\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":4},\n" +
                "{\"VOL\":\"69\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":7},\n" +
                "{\"VOL\":\"70\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":5},\n" +
                "{\"VOL\":\"71\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":3},\n" +
                "{\"VOL\":\"72\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":4},\n" +
                "{\"VOL\":\"73\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":2},\n" +
                "{\"VOL\":\"74\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":8},\n" +
                "{\"VOL\":\"75\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":6},\n" +
                "{\"VOL\":\"76\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":18},\n" +
                "{\"VOL\":\"77\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":1},\n" +
                "{\"VOL\":\"78\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":1},\n" +
                "{\"VOL\":\"79\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":20},\n" +
                "{\"VOL\":\"80\",\"DEPART\":0,\"DUREE\":6,\"PRIX\":12},\n" +
                "{\"VOL\":\"81\",\"DEPART\":0,\"DUREE\":10,\"PRIX\":15},\n" +
                "{\"VOL\":\"82\",\"DEPART\":0,\"DUREE\":2,\"PRIX\":3},\n" +
                "{\"VOL\":\"83\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":17},\n" +
                "{\"VOL\":\"84\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":5},\n" +
                "{\"VOL\":\"85\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":10},\n" +
                "{\"VOL\":\"86\",\"DEPART\":0,\"DUREE\":8,\"PRIX\":14},\n" +
                "{\"VOL\":\"87\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":19},\n" +
                "{\"VOL\":\"88\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":7},\n" +
                "{\"VOL\":\"89\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":1},\n" +
                "{\"VOL\":\"90\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":13},\n" +
                "{\"VOL\":\"91\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":10},\n" +
                "{\"VOL\":\"92\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":7},\n" +
                "{\"VOL\":\"93\",\"DEPART\":0,\"DUREE\":7,\"PRIX\":9},\n" +
                "{\"VOL\":\"94\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":2},\n" +
                "{\"VOL\":\"95\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":5},\n" +
                "{\"VOL\":\"96\",\"DEPART\":0,\"DUREE\":4,\"PRIX\":19},\n" +
                "{\"VOL\":\"97\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":9},\n" +
                "{\"VOL\":\"98\",\"DEPART\":0,\"DUREE\":3,\"PRIX\":20},\n" +
                "{\"VOL\":\"99\",\"DEPART\":0,\"DUREE\":1,\"PRIX\":1}]";

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
