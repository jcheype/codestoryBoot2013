package com.jcheype.codestory2013.enonce2;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mush
 * Date: 1/18/13
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Optimizer {
    Logger logger = LoggerFactory.getLogger(Optimizer.class);

//    public List<Vol> optimize(List<Vol> path, List<Vol> vols){
////       logger.debug("pathOptimized: {}", path);
//
//        Vol last=null;
//        if(!path.isEmpty())
//            last = Iterables.getLast(path);
//
//        List<Vol> pathOptimized = path;
//        int price = price(path);
//
//        for(Vol vol: vols){
//            if(last!= null && vol.isNext(last))
//                continue;
//            if((last == null || last.isNext(vol) )){
//                List<Vol> volsCopy = new ArrayList<Vol>(vols);
//                LinkedList<Vol> pathCopy = new LinkedList<Vol>(path);
//                volsCopy.remove(vol);
//                pathCopy.add(vol);
//                List<Vol> tmpPath = optimize(pathCopy, volsCopy);
//                int tmpPrice = price(tmpPath);
//                if(tmpPrice>price){
//                    pathOptimized = tmpPath;
//                    price = tmpPrice;
//                }
//            }
//        }
//
//        return pathOptimized;
//    }

    public List<Vol> optimize2(Vol last, List<Vol> vols) {
        List<Vol> pathOptimized = null;
        int price = 0;

        for (Vol vol : vols.toArray(new Vol[]{})) {
            if ((last == null || last.isNext(vol))) {
                vols.remove(vol);
                List<Vol> tmpPath = optimize2(vol, vols);
                int tmpPrice = price(tmpPath);
                if (tmpPrice > price) {
                    pathOptimized = tmpPath;
                    price = tmpPrice;
                }
                vols.add(vol);
            }
        }

        if (pathOptimized == null)
            pathOptimized = new ArrayList<Vol>();
        if (last != null)
            pathOptimized.add(0, last);

        return pathOptimized;
    }


    public List<Vol> optimize3(Vol last, List<Vol> vols) {
        List<Vol> pathOptimized = null;
        int price = 0;

        Vol bestVol = null;
        for (Vol vol : vols.toArray(new Vol[]{})) {
            if ((last == null || last.isNext(vol)) && (bestVol == null || !bestVol.isNext(vol))) {
                vols.remove(vol);
                List<Vol> tmpPath = optimize3(vol, vols);
                int tmpPrice = price(tmpPath);
                if (tmpPrice > price) {
                    pathOptimized = tmpPath;
                    price = tmpPrice;
                    bestVol = vol;
                }
                vols.add(vol);
            }
        }

        if (pathOptimized == null)
            pathOptimized = new ArrayList<Vol>();
        if (last != null)
            pathOptimized.add(0, last);

        return pathOptimized;
    }


    Map<Integer, Path> cache = new HashMap<Integer, Path>();

    public List<Vol> optimize4(List<Vol> vols) {

        Collections.sort(vols, new VolComparator(-1));
        Iterator<Vol> iterator = vols.iterator();
        Vol vol = iterator.next();
        int maxTime = vol.getDepart();

        Path last = null;
        while (maxTime > -1) {
            while (vol.getDepart() == maxTime) {
                Path path = cache.get(vol.getEnd());
                Path newPath;
                if (path != null) {
                    newPath = new Path(path);
                    newPath.add(vol);
                } else
                    newPath = new Path(vol);

                if (last == null || newPath.getGain() > last.getGain()) {
                    last = newPath;
                }
                if (iterator.hasNext())
                    vol = iterator.next();
                else
                    break;
            }
            cache.put(maxTime, last);

            maxTime--;
        }

        return last.getVols();
    }


    private int getMaxTime(List<Vol> vols) {
        int maxTime = 0;
        for (Vol vol : vols) {
            int end = vol.getEnd();
            if (end > maxTime) {
                maxTime = end;
            }
        }
        return maxTime;
    }


    public static int price(List<Vol> optimize) {
        int price = 0;
        for (Vol vol : optimize) {
            price += vol.getPrix();
        }
        return price;
    }

    public Map format(List<Vol> vols) {
        int price = price(vols);
        LinkedList<String> path = new LinkedList<String>();
        for (Vol vol : vols) {
            path.add(vol.getVol());
        }
        HashMap result = new HashMap();
        result.put("gain", price);
        result.put("path", path);
        return result;
    }

    public String formatString(List<Vol> vols) {
        String template = "{\n" +
                "    \"gain\" : %d,\n" +
                "    \"path\" : %s\n" +
                "}";

        int price = price(vols);
        LinkedList<String> path = new LinkedList<String>();
        for (Vol vol : vols) {
            path.add("\"" + vol.getVol() + "\"");
        }

        String result = String.format(template, price, path);

        return result;
    }

}
