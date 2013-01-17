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
    public void test12_plus_13(){
        Double calc = SimpleCalc.calc("12 13");
        assertThat(calc).isEqualTo(25);
    }

    @Test
    public void test12_minus_13(){
        Double calc = SimpleCalc.calc("12-13");
        assertThat(calc).isEqualTo(-1);
    }

    @Test
    public void test12_multiply_13(){
        Double calc = SimpleCalc.calc("12*13");
        assertThat(calc).isEqualTo(12*13);
    }

    @Test
    public void testMore(){
        Double calc = SimpleCalc.calc("(1+2)/2");
        System.out.println(calc);
        assertThat(calc).isEqualTo((1.0+2)/2);
    }
}
