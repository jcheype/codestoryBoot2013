package com.jcheype.codestory2013.enonce2;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 18/01/13
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public class VolComparator implements Comparator<Vol> {
    private final int way;
    public VolComparator() {
        this(1);
    }

    public VolComparator(int i) {
        way = i;
    }

    @Override
    public int compare(Vol v1, Vol v2) {
        if (v1.getDepart()>v2.getDepart()) return 1*way;
        else if((v1.getDepart()<v2.getDepart())) return -1*way;
        else return 0;
    }
}
