package com.jcheype.codestory2013.simpleCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 17/01/13
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCalc {
    static Pattern regex = Pattern.compile("(\\d+)(.)(\\d+)");

    public static Integer calc(String q){
        Matcher matcher = regex.matcher(q);
        if(matcher.find()){
            String v1 = matcher.group(1);
            String sign = matcher.group(2);
            String v2 = matcher.group(3);

            if(sign.equals(" "))
                return Integer.parseInt(v1) + Integer.parseInt(v2);
            if(sign.equals("*"))
                return Integer.parseInt(v1) * Integer.parseInt(v2);
            if(sign.equals("-"))
                return Integer.parseInt(v1) - Integer.parseInt(v2);
            if(sign.equals("/"))
                return Integer.parseInt(v1) / Integer.parseInt(v2);
        }

        return null;
    }
}
