package ru.omsu.base.properties;

/**
 * Storage program properties.
 */
public interface Properties {
    /**
     * Getter.
     * @return the string - indent.
     */
    public String getIndent();

    /**
     * Getter.
     * @return the character - new line.
     */
    public String getNewLine();

    /**
     * Getter.
     * @return the length of string - indent.
     */
    public int getLengthIndent();

    /**
     * Increase the string - indent.
     */
    public void increaseIndent();

    /**
     * Reduce the string 'indent'.
     */
    public void reduceIndent();
}
