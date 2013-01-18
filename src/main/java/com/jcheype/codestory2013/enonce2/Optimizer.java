package com.jcheype.codestory2013.enonce2;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
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

    public List<Vol> optimize(List<Vol> path, List<Vol> vols){
//       logger.debug("pathOptimized: {}", path);

        Vol last=null;
        if(!path.isEmpty())
            last = Iterables.getLast(path);

        List<Vol> pathOptimized = path;
        int price = price(path);

        for(Vol vol: vols){
            if(last!= null && vol.isNext(last))
                continue;
            if((last == null || last.isNext(vol) )){
                List<Vol> volsCopy = new ArrayList<Vol>(vols);
                LinkedList<Vol> pathCopy = new LinkedList<Vol>(path);
                volsCopy.remove(vol);
                pathCopy.add(vol);
                List<Vol> tmpPath = optimize(pathCopy, volsCopy);
                int tmpPrice = price(tmpPath);
                if(tmpPrice>price){
                    pathOptimized = tmpPath;
                    price = tmpPrice;
                }
            }
        }

        return pathOptimized;
    }

    public List<Vol> optimize2(Vol last, List<Vol> vols){
        List<Vol> pathOptimized = null;
        int price = 0;

        for(Vol vol: vols.toArray(new Vol[]{})){
            if((last == null || last.isNext(vol) )){
                vols.remove(vol);
                List<Vol> tmpPath = optimize2(vol, vols);
                int tmpPrice = price(tmpPath);
                if(tmpPrice>price){
                    pathOptimized = tmpPath;
                    price = tmpPrice;
                }
                vols.add(vol);
            }
        }

        if(pathOptimized == null)
            pathOptimized = new ArrayList<Vol>();
        if(last != null)
            pathOptimized.add(0, last);

        return pathOptimized;
    }

    private int price(List<Vol> optimize) {
        int price = 0;
        for(Vol vol : optimize){
            price += vol.getPrix();
        }
        return price;
    }

    public Map format(List<Vol> vols){
        int price = price(vols);
        LinkedList<String> path = new LinkedList<String>();
        for(Vol vol : vols){
            path.add(vol.getVol());
        }
        HashMap result = new HashMap();
        result.put("gain", price);
        result.put("path", path);
        return result;
    }
    public String formatString(List<Vol> vols){
        String template = "{\n" +
                "    \"gain\" : %d,\n" +
                "    \"path\" : %s\n" +
                "}";

        int price = price(vols);
        LinkedList<String> path = new LinkedList<String>();
        for(Vol vol : vols){
            path.add("\""+vol.getVol()+"\"");
        }

        String result = String.format(template, price, path);

        return result;
    }

}
