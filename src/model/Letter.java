package model;

/**
 * Created by Connor on 2016-02-25.
 */
public enum Letter {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J"),
    K("K"),
    L("L"),
    M("M"),
    N("N"),
    O("O"),
    P("P"),
    Q("Q"),
    R("R"),
    S("S"),
    T("T"),
    U("U"),
    V("V"),
    W("W"),
    X("X"),
    Y("Y"),
    Z("Z");

    private String letter;

    private Letter(String newLetter) {
        this.letter = newLetter;
    }

    public final String getLetter() { return this.letter; }
}
