package ru.omsu.base.input;

import ru.omsu.base.Char.BaseChar;

/**
 * BaseInput - The class stores the characters received from the stream
 * and the previous character.
 * Implements an interface BaseChar.
 */
public class BaseInput implements BaseChar {
    private char prevSymbol;
    private char inputSymbol;

    /**
     * Constructor.
     */
    public BaseInput() {
        prevSymbol = 'n';
        inputSymbol = 'n';
    }

    /**
     * getPrevSymbol() - Method return previous character from stream.
     * @return
     */
    public char getPrevSymbol() {
        return prevSymbol;
    }

    /**
     * getInputSymbol() - Method return incoming character from stream.
     * @return
     */
    public char getInputSymbol() {
        return inputSymbol;
    }

    /**
     * setInputSymbol(char) - Method sets a field of class incoming character
     * from stream.
     * @param inputSymbol
     */
    public void setInputSymbol(char inputSymbol) {
        prevSymbol = this.inputSymbol;
        this.inputSymbol = inputSymbol;
    }
}
