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
//        logger.debug("pathOptimized: {}", path);

        Vol last=null;
        if(!path.isEmpty())
            last = Iterables.getLast(path);

        List<Vol> pathOptimized = path;

        for(Vol vol: vols){

            if(last == null || last.isNext(vol)){
                LinkedList<Vol> volsCopy = new LinkedList<Vol>(vols);
                LinkedList<Vol> pathCopy = new LinkedList<Vol>(path);
                volsCopy.remove(vol);
                pathCopy.add(vol);
                pathOptimized =  best(pathOptimized, optimize(pathCopy, volsCopy));
            }
        }

        return pathOptimized;
    }

    private List<Vol> best(List<Vol> pathOptimized, List<Vol> optimize) {
        if(pathOptimized == null)
            return optimize;

        return price(pathOptimized)>price(optimize)?pathOptimized:optimize;
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
