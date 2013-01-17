package com.jcheype.codestory2013.enonce1;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 17/01/13
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
public class Enonce1 {
    Logger logger = LoggerFactory.getLogger(Enonce1.class);

    Map<Integer, Set<FooBar>> decompositionMap = new HashMap<Integer, Set<FooBar>>();

    Set<FooBar> getDecomposeList(int value, Piece piece, Map<Integer, Set<FooBar>> decompositionMap){
        //logger.debug(String.format("value[%s] piece[%s]", value, piece));
        if(value < piece.getValue())
            return Collections.EMPTY_SET;

        Set<FooBar> result = new HashSet<FooBar>();

        if(value == piece.getValue()){
            FooBar fooBar = new FooBar();
            fooBar.add(piece);
            result.add(fooBar);
        }

        for(FooBar fooBar : decompositionMap.get(value-piece.getValue())){
            result.add(fooBar.copy().add(piece));
        }


        return result;
    }

    public Enonce1(int to) {
        decompositionMap.put(0, Collections.EMPTY_SET);

        for(int i=1; i<to+1; i++){
            Set<FooBar> decomposeList = new HashSet<FooBar>();
            for(Piece p : Piece.values()){
                decomposeList.addAll(getDecomposeList(i, p, decompositionMap));
            }
            decompositionMap.put(i, decomposeList);
        }
    }

    public Collection decompose(int to){
        Set<FooBar> fooBars = decompositionMap.get(to);
        return Collections2.transform(fooBars, new Function<FooBar, Object>() {
            @Override
            public Object apply(FooBar fooBar) {
                return fooBar.toMap();
            }
        });
    }
}
