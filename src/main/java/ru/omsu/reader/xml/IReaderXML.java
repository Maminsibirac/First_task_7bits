package ru.omsu.reader.xml;

/**
 * Interface for reading XML documents.
 */
public interface IReaderXML {
    /**
     * Getter.
     * @return has read XML document.
     */
    public org.w3c.dom.Document getDocument();

    /**
     * Read value tag in XML document.
     * @param tagName
     * @return value inside the tag, with name - tagName.
     */
    public String getChildValue(String tagName);
}
