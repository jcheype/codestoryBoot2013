package com.jcheype.codestory2013;

import com.jcheype.codestory2013.enonce1.Enonce1;
import org.junit.Test;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 17/01/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Enonce1Test {
    Enonce1 enonce1 = new Enonce1(100);

    @Test
    public void enonce1Test(){
        Collection decompose = enonce1.decompose(7);
        System.out.println(decompose);
        assertThat(decompose).hasSize(2);
    }

    @Test
    public void enonce1Test11(){
        Collection decompose = enonce1.decompose(11);
        System.out.println(decompose);
        assertThat(decompose).hasSize(3);
    }

}
