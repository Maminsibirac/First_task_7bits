package ru.omsu.reader.dom_parser;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.omsu.exception.NullTagValueException;
import ru.omsu.reader.xml.IReaderXML;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The class reads a XML documents, using Dom XML Parser Java API.
 */
public class DomXmlParser implements IReaderXML {
    private static final Logger logger = Logger.getLogger(DomXmlParser.class);
    private org.w3c.dom.Document document;

    /**
     * Getter.
     * @return has read XML document.
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
     * Read value tag in XML document.
     * @param tagName
     * @return value inside the tag, with name - tagName.
     */
    public String getChildValue(String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        Element element = (Element)nodeList.item(0);

        try {
             String result = element.getChildNodes().item(0).getNodeValue();
        }
        catch(NullPointerException e) {
            NullTagValueException exception = new NullTagValueException("Tag with name: '" + tagName + "' is Empty!");
            logger.error(exception.getMessageError());
            System.exit(1);
        }

        return element.getChildNodes().item(0).getNodeValue();
    }
}
