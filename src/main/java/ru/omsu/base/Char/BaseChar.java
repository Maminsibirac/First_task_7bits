package ru.omsu.base.Char;

/**
 * BaseChar - Interface for storage character.
 */
public interface BaseChar {
    /**
     * getPrevSymbol() - Method return previous character from stream.
     * @return
     */
    public char getPrevSymbol();

    /**
     * getInputSymbol() - Method return incoming character from stream.
     * @return
     */
    public char getInputSymbol();

    /**
     * setInputSymbol(char) - Method sets a field of class incoming character
     * from stream.
     * @param inputSymbol
     */
    public void setInputSymbol(char inputSymbol);
}
