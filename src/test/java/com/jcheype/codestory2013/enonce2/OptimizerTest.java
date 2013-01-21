package com.jcheype.codestory2013.enonce2;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.fest.assertions.Assertions.assertThat;

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

    private final String json2 = "[ { \"VOL\": \"gleaming-therapy-54\", \"DEPART\": 0, \"DUREE\": 4, \"PRIX\": 13 }, { \"VOL\": \"happy-paperwork-32\", \"DEPART\": 1, \"DUREE\": 2, \"PRIX\": 8 }, { \"VOL\": \"lovely-bump-69\", \"DEPART\": 2, \"DUREE\": 6, \"PRIX\": 2 }, { \"VOL\": \"fierce-superstar-2\", \"DEPART\": 4, \"DUREE\": 5, \"PRIX\": 5 }, { \"VOL\": \"short-matt-96\", \"DEPART\": 5, \"DUREE\": 2, \"PRIX\": 15 }, { \"VOL\": \"rich-whiff-99\", \"DEPART\": 5, \"DUREE\": 4, \"PRIX\": 8 }, { \"VOL\": \"expensive-strawberry-50\", \"DEPART\": 6, \"DUREE\": 2, \"PRIX\": 6 }, { \"VOL\": \"shallow-magnet-35\", \"DEPART\": 7, \"DUREE\": 6, \"PRIX\": 7 }, { \"VOL\": \"courageous-shoelace-3\", \"DEPART\": 9, \"DUREE\": 5, \"PRIX\": 16 }, { \"VOL\": \"tired-nursery-27\", \"DEPART\": 10, \"DUREE\": 2, \"PRIX\": 5 }, { \"VOL\": \"resonant-underwear-47\", \"DEPART\": 10, \"DUREE\": 4, \"PRIX\": 12 }, { \"VOL\": \"strange-sandal-26\", \"DEPART\": 11, \"DUREE\": 2, \"PRIX\": 3 }, { \"VOL\": \"ancient-sword-10\", \"DEPART\": 12, \"DUREE\": 6, \"PRIX\": 6 }, { \"VOL\": \"stupid-mountain-50\", \"DEPART\": 14, \"DUREE\": 5, \"PRIX\": 7 }, { \"VOL\": \"condemned-tomahawk-59\", \"DEPART\": 15, \"DUREE\": 2, \"PRIX\": 12 }, { \"VOL\": \"gifted-acorn-55\", \"DEPART\": 15, \"DUREE\": 4, \"PRIX\": 9 }, { \"VOL\": \"splendid-skipper-45\", \"DEPART\": 16, \"DUREE\": 2, \"PRIX\": 8 }, { \"VOL\": \"chubby-navy-89\", \"DEPART\": 17, \"DUREE\": 6, \"PRIX\": 2 }, { \"VOL\": \"lucky-arrow-92\", \"DEPART\": 19, \"DUREE\": 5, \"PRIX\": 22 }, { \"VOL\": \"flat-semiconductor-50\", \"DEPART\": 20, \"DUREE\": 2, \"PRIX\": 25 }, { \"VOL\": \"light-vandalism-18\", \"DEPART\": 20, \"DUREE\": 4, \"PRIX\": 10 }, { \"VOL\": \"thoughtful-balance-76\", \"DEPART\": 21, \"DUREE\": 2, \"PRIX\": 5 }, { \"VOL\": \"upset-tiller-76\", \"DEPART\": 22, \"DUREE\": 6, \"PRIX\": 4 }, { \"VOL\": \"high-slot-51\", \"DEPART\": 24, \"DUREE\": 5, \"PRIX\": 8 }, { \"VOL\": \"wandering-juror-86\", \"DEPART\": 25, \"DUREE\": 2, \"PRIX\": 23 }, { \"VOL\": \"calm-spat-24\", \"DEPART\": 25, \"DUREE\": 4, \"PRIX\": 9 }, { \"VOL\": \"talented-cuttlefish-97\", \"DEPART\": 26, \"DUREE\": 2, \"PRIX\": 8 }, { \"VOL\": \"hissing-bacteria-9\", \"DEPART\": 27, \"DUREE\": 6, \"PRIX\": 6 }, { \"VOL\": \"raspy-factory-72\", \"DEPART\": 29, \"DUREE\": 5, \"PRIX\": 11 }, { \"VOL\": \"ancient-dove-68\", \"DEPART\": 30, \"DUREE\": 2, \"PRIX\": 9 }, { \"VOL\": \"disturbed-watchdog-31\", \"DEPART\": 30, \"DUREE\": 4, \"PRIX\": 7 }, { \"VOL\": \"important-lady-90\", \"DEPART\": 31, \"DUREE\": 2, \"PRIX\": 7 }, { \"VOL\": \"exuberant-knob-75\", \"DEPART\": 32, \"DUREE\": 6, \"PRIX\": 5 }, { \"VOL\": \"poised-hairbrush-81\", \"DEPART\": 34, \"DUREE\": 5, \"PRIX\": 7 }, { \"VOL\": \"homely-burglar-94\", \"DEPART\": 35, \"DUREE\": 2, \"PRIX\": 12 }, { \"VOL\": \"modern-redwood-6\", \"DEPART\": 35, \"DUREE\": 4, \"PRIX\": 12 }, { \"VOL\": \"angry-camper-36\", \"DEPART\": 36, \"DUREE\": 2, \"PRIX\": 5 }, { \"VOL\": \"miniature-scarecrow-36\", \"DEPART\": 37, \"DUREE\": 6, \"PRIX\": 6 }, { \"VOL\": \"eager-weapon-63\", \"DEPART\": 39, \"DUREE\": 5, \"PRIX\": 13 }, { \"VOL\": \"wrong-roadway-98\", \"DEPART\": 40, \"DUREE\": 2, \"PRIX\": 13 }, { \"VOL\": \"gigantic-petroleum-50\", \"DEPART\": 40, \"DUREE\": 4, \"PRIX\": 12 }, { \"VOL\": \"faithful-missionary-73\", \"DEPART\": 41, \"DUREE\": 2, \"PRIX\": 7 }, { \"VOL\": \"innocent-user-14\", \"DEPART\": 42, \"DUREE\": 6, \"PRIX\": 2 }, { \"VOL\": \"mushy-password-70\", \"DEPART\": 44, \"DUREE\": 5, \"PRIX\": 15 }, { \"VOL\": \"lonely-leadership-21\", \"DEPART\": 45, \"DUREE\": 2, \"PRIX\": 13 }, { \"VOL\": \"itchy-infant-38\", \"DEPART\": 45, \"DUREE\": 4, \"PRIX\": 9 }, { \"VOL\": \"brief-axle-25\", \"DEPART\": 46, \"DUREE\": 2, \"PRIX\": 8 }, { \"VOL\": \"attractive-puffin-59\", \"DEPART\": 47, \"DUREE\": 6, \"PRIX\": 3 }, { \"VOL\": \"busy-silkscreen-8\", \"DEPART\": 49, \"DUREE\": 5, \"PRIX\": 21 }, { \"VOL\": \"cheerful-giant-28\", \"DEPART\": 50, \"DUREE\": 2, \"PRIX\": 17 }, { \"VOL\": \"puzzled-alfalfa-1\", \"DEPART\": 50, \"DUREE\": 4, \"PRIX\": 10 }, { \"VOL\": \"scrawny-backside-13\", \"DEPART\": 51, \"DUREE\": 2, \"PRIX\": 7 }, { \"VOL\": \"lonely-freight-44\", \"DEPART\": 52, \"DUREE\": 6, \"PRIX\": 4 }, { \"VOL\": \"curved-ostrich-71\", \"DEPART\": 54, \"DUREE\": 5, \"PRIX\": 12 }, { \"VOL\": \"repulsive-ulcer-83\", \"DEPART\": 55, \"DUREE\": 2, \"PRIX\": 26 } ]\n";
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
        List<Vol> optimize = optimizer.optimize4(Vol.fromMaps(maps));
        System.out.println(optimizer.formatString(optimize));
    }

    @Test
    public void optimizeRand() throws IOException {
        Optimizer optimizer = new Optimizer();
        long start;
        List<Vol> optimize;

        for (int i = 0; i < 1; i++) {
            List<Vol> list = randList(100000);

            start = System.currentTimeMillis();
//            optimize = optimizer.optimize3(null, list);
//            System.out.println(optimizer.formatString(optimize));
//            System.out.println(System.currentTimeMillis() - start);
//            System.out.println(Vol.toString(optimize));

            start = System.currentTimeMillis();
            List<Vol> optimize2 = optimizer.optimize4(list);
            long duration = System.currentTimeMillis() - start;
            System.out.println(optimizer.formatString(optimize2));
            System.out.println(duration);
//            System.out.println(Vol.toString(optimize2));

//            assertThat(Optimizer.price(optimize)).isLessThanOrEqualTo(Optimizer.price(optimize2));
            Iterator<Vol> iterator = optimize2.iterator();

            Vol vol = iterator.next();
            while(iterator.hasNext()){
                Vol next = iterator.next();
                assertThat(vol.isNext(next)).isTrue();
                vol = next;
            }
        }
    }

    @Test
    public void genFile() throws IOException {
        List<Vol> list = randList(100000);
        mapper.writeValue(new File("tmp.json"), list);
    }

    private List<Vol> randList(int size) {
        List<Vol> vols = new LinkedList<Vol>();
        for (int i = 0; i < size; i++) {
            Vol vol = new Vol();
            vol.setDepart(rand.nextInt(50000));
            vol.setDuree(rand.nextInt(100) + 1);
            vol.setPrix(rand.nextInt(15000));
            vol.setVol(UUID.randomUUID().toString());
            vols.add(vol);
        }

        return vols;
    }


}
