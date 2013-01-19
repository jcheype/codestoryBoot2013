package com.jcheype.codestory2013.enonce2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 18/01/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class Path{
    static Logger logger = LoggerFactory.getLogger(Path.class);

    ArrayList<Vol> vols;
    int gain;

    public Path(Vol vol) {
        ArrayList<Vol> vols = new ArrayList<Vol>();
        vols.add(vol);
        this.vols = vols;
        this.gain = vol.getPrix();
    }

    public Path(Path p) {
        this.vols = (ArrayList<Vol>) p.getVols().clone();
        this.gain = p.getGain();
    }

    public boolean add(Vol vol){
        vols.add(0, vol);
        gain += vol.getPrix();
        return true;
    }

    private int price(List<Vol> optimize) {
        int price = 0;
        for (Vol vol : optimize) {
            price += vol.getPrix();
        }
        return price;
    }

    public ArrayList<Vol> getVols() {
        return vols;
    }

    public int getGain() {
        return gain;
    }

    @Override
    public String toString() {
        return "Path{" +
                "vols=" + vols +
                ", gain=" + gain +
                '}';
    }
}
