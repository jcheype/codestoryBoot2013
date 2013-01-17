package com.jcheype.codestory2013;

import com.jcheype.codestory2013.simpleCalc.SimpleCalc;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 17/01/13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCalcTest {

    @Test
    public void test12_13(){
        Integer calc = SimpleCalc.calc("12 13");
        assertThat(calc).isEqualTo(25);
    }
}
