package ru.omsu.reader.xml;

/**
 * IReaderXML - Interface for reading XML documents.
 */
public interface IReaderXML {
    /**
     * getDocument() - Method returns has read XML document.
     * @return
     */
    public org.w3c.dom.Document getDocument();

    /**
     * getChildValue(String tagName) - Method returns value inside the tag, with name 'tagName'.
     * @param tagName
     * @return
     */
    public String getChildValue(String tagName);
}
