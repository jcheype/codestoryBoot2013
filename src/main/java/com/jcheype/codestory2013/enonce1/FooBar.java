package com.jcheype.codestory2013.enonce1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 17/01/13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class FooBar {
    public int foo = 0;
    public int bar = 0;
    public int qix = 0;
    public int baz = 0;

    public FooBar copy(){
        FooBar fooBar = new FooBar();
        fooBar.foo = foo;
        fooBar.bar = bar;
        fooBar.qix = qix;
        fooBar.baz = baz;
        return fooBar;
    }

    public FooBar add(Piece p){
        switch (p){
            case FOO: foo++;
                break;
            case BAR: bar++;
                break;
            case QIX: qix++;
                break;
            case BAZ: baz++;
                break;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FooBar fooBar = (FooBar) o;

        if (bar != fooBar.bar) return false;
        if (baz != fooBar.baz) return false;
        if (foo != fooBar.foo) return false;
        if (qix != fooBar.qix) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foo;
        result = 31 * result + bar;
        result = 31 * result + qix;
        result = 31 * result + baz;
        return result;
    }

    @Override
    public String toString() {
        return "FooBar{" +
                "foo=" + foo +
                ", bar=" + bar +
                ", qix=" + qix +
                ", baz=" + baz +
                '}';
    }

    public Map<String, Integer> toMap(){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if(foo>0)
            map.put("foo", foo);
        if(bar>0)
            map.put("bar", bar);
        if(qix >0)
            map.put("qix", qix);
        if(baz>0)
            map.put("baz", baz);

        return map;
    }
}
