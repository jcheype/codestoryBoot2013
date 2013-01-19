package com.jcheype.codestory2013.enonce2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mush
 * Date: 1/18/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vol {
    private String vol;
    private int depart;
    private int duree;
    private int prix;

    public boolean isNext(Vol vol) {
        return vol.getDepart() >= getEnd();
    }

    public int getEnd() {
        return getDepart() + getDuree();
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vol vol1 = (Vol) o;

        if (depart != vol1.depart) return false;
        if (duree != vol1.duree) return false;
        if (prix != vol1.prix) return false;
        if (vol != null ? !vol.equals(vol1.vol) : vol1.vol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vol != null ? vol.hashCode() : 0;
        result = 31 * result + depart;
        result = 31 * result + duree;
        result = 31 * result + prix;
        return result;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "vol='" + vol + '\'' +
                ", depart=" + depart +
                ", duree=" + duree +
                ", prix=" + prix +
                '}';
    }

    public static List<Vol> fromMaps(List<Map> volsMap) {
        LinkedList<Vol> vols = new LinkedList<Vol>();
        for (Map map : volsMap) {
            Vol vol = new Vol();
            vol.setDepart((Integer) map.get("DEPART"));
            vol.setDuree((Integer) map.get("DUREE"));
            vol.setPrix((Integer) map.get("PRIX"));
            vol.setVol((String) map.get("VOL"));
            vols.add(vol);
        }
        return vols;
    }

    public static String toString(List<Vol> vols) {

        StringBuilder sb = new StringBuilder();
        for (Vol vol : vols) {
            sb.append(vol.getDepart()).append("->").append(vol.getEnd()).append(" ");
        }

        return sb.toString();

    }
}
