package com.jcheype.codestory2013.enonce2;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

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
    private Random rand = new Random();


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
        List<Vol> optimize = optimizer.optimize3(null, Vol.fromMaps(maps));
        System.out.println(optimizer.formatString(optimize));
    }

    @Test
    public void optimizeRand() throws IOException {
        Optimizer optimizer = new Optimizer();
        List<Vol> list = randList(50);
        Collections.sort(list, new VolComparator());
        long start;
        List<Vol> optimize;
//        start = System.currentTimeMillis();
//         optimize = optimizer.optimize2(null, list);
//        System.out.println(optimizer.formatString(optimize));
//        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        optimize = optimizer.optimize3(null, list);
        System.out.println(optimizer.formatString(optimize));
        System.out.println(System.currentTimeMillis() - start);

    }

    private List<Vol> randList(int size){
        List<Vol> vols = new ArrayList<Vol>();
        for(int i = 0; i<size; i++){
            Vol vol = new Vol();
            vol.setDepart(rand.nextInt(50));
            vol.setDuree(rand.nextInt(10));
            vol.setPrix(rand.nextInt(15));
            vol.setVol(UUID.randomUUID().toString());
            vols.add(vol);
        }

        return vols;
    }
}
