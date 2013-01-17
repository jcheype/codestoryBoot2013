package com.jcheype.codestory2013.enonce1;

/**
 * Created with IntelliJ IDEA.
 * User: jcheype
 * Date: 17/01/13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public enum Piece {
    FOO(1),
    BAR(7),
    QIX(11),
    BAZ(21);

    private final int value;

    Piece(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
