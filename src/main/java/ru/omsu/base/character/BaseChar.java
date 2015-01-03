package ru.omsu.base.character;

/**
 * Interface for storage character.
 */
public interface BaseChar {

    /**
     * Getter.
     * @return previous character from stream.
     */
    public char getPrevSymbol();

    /**
     * Getter.
     * @return incoming character from stream.
     */
    public char getInputSymbol();

    /**
     * Setter.
     * @param inputSymbol
     */
    public void setInputSymbol(char inputSymbol);
}
