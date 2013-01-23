package com.jcheype.codestory2013.simpleCalc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
    static Logger logger = LoggerFactory.getLogger(SimpleCalc.class);

    static Pattern regex = Pattern.compile("(\\d+)(.)(\\d+)");
    static ScriptEngineManager factory = new ScriptEngineManager();
    // create a JavaScript engine
    static ScriptEngine engine = factory.getEngineByName("groovy");
    public static Number calc(String q) {
        try {
            String s = q.replaceAll(" +", "+").replaceAll("[a-zA-Z]", "");
            s = s.replaceAll(",", ".");
            return ((Number) engine.eval(s));
        } catch (ScriptException e) {
            logger.warn("cannot run");
            logger.trace("cannot run", e);
        }
        return null;
    }

    // evaluate JavaScript code from String



//    public static Integer calc(String q){
//
//
//        Matcher matcher = regex.matcher(q);
//        if(matcher.find()){
//            String v1 = matcher.group(1);
//            String sign = matcher.group(2);
//            String v2 = matcher.group(3);
//
//            if(sign.equals(" "))
//                return Integer.parseInt(v1) + Integer.parseInt(v2);
//            if(sign.equals("*"))
//                return Integer.parseInt(v1) * Integer.parseInt(v2);
//            if(sign.equals("-"))
//                return Integer.parseInt(v1) - Integer.parseInt(v2);
//            if(sign.equals("/"))
//                return Integer.parseInt(v1) / Integer.parseInt(v2);
//        }
//
//        return null;
//    }
}
