package ru.omsu.base.xml;

/**
 * BaseXml - Interface for storage XML documents.
 */
public interface BaseXml {
    /**
     * getIndent() - Method returns the string 'indent'.
     * @return
     */
    public String getIndent();

    /**
     * getNewLine() - Method returns the character 'new line'.
     * @return
     */
    public String getNewLine();

    /**
     * getLengthIndent() - Method returns the length of string 'indent'.
     * @return
     */
    public int getLengthIndent();

    /**
     * increaseIndent() - Method increase the string 'indent'.
     */
    public void increaseIndent();

    /**
     * reduceIndent() - Method reduce the string 'indent'.
     */
    public void reduceIndent();
}
