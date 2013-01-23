package com.jcheype.codestory2013;

import com.jcheype.codestory2013.simpleCalc.SimpleCalc;
import org.junit.Test;

import java.text.DecimalFormat;

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
        Number calc = SimpleCalc.calc("12 13");
        assertThat(calc).isEqualTo(25);
    }

    @Test
    public void test12_minus_13(){
        Number calc = SimpleCalc.calc("12-13");
        assertThat(calc).isEqualTo(-1);
    }

    @Test
    public void test12_multiply_13(){
        Number calc = SimpleCalc.calc("12*13");
        assertThat(calc).isEqualTo(12*13);
    }

    @Test
    public void testMore(){
        Number calc = SimpleCalc.calc("(1+2)/2");
        DecimalFormat df = new DecimalFormat();

        df.setParseIntegerOnly(true);
        System.out.println(df.format(calc));

        //assertThat(calc).isEqualTo((1.0+2)/2);
    }

    @Test
    public void testFloat(){
        Number calc = SimpleCalc.calc("1,5*4");
        DecimalFormat df = new DecimalFormat();

        df.setParseIntegerOnly(true);
        System.out.println(df.format(calc));

        //assertThat(calc).isEqualTo(1.5*4);
    }

    @Test
    public void testBig(){
        Number calc = SimpleCalc.calc("((1,1 2) 3,14 4 (5 6 7) (8 9 10)*4267387833344334647677634)/2*553344300034334349999000");
        DecimalFormat df = new DecimalFormat();
        df.setParseIntegerOnly(true);
        df.setMaximumIntegerDigits(50);
        df.setGroupingUsed(false);

        System.out.println(df.format(calc));
    }
}
