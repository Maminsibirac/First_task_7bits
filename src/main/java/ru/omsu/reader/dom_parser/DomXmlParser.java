package ru.omsu.reader.dom_parser;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.omsu.reader.xml.IReaderXML;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * DomXmlParser - The class reads a XML documents, using Dom XML Parser Java API.
 * Implements an interface IReaderXML.
 */
public class DomXmlParser implements IReaderXML {
    private static final Logger logger = Logger.getLogger(DomXmlParser.class);
    private org.w3c.dom.Document document;

    /**
     * getDocument() - Method returns has read XML document.
     * @return
     */
    public org.w3c.dom.Document getDocument(){
        return document;
    }

    /**
     * Constructor
     * @param fileName
     */
    public DomXmlParser(String fileName) {
        try {
            DocumentBuilderFactory documentBuilderFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();

            document = documentBuilder.parse(fileName);
        }
        catch(SAXException e){
            logger.error(e);
        }
        catch(ParserConfigurationException e) {
            logger.error(e);
        }
        catch(IOException e){
            logger.error(e);
        }
    }

    /**
     * getChildValue(String tagName) - Method returns value inside the tag, with name 'tagName'.
     * @param tagName
     * @return
     */
    public String getChildValue(String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        Element element = (Element)nodeList.item(0);

        return element.getChildNodes().item(0).getNodeValue();
    }
}
