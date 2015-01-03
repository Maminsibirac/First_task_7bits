package ru.omsu.base.memory;

import org.apache.log4j.Logger;
import ru.omsu.base.character.BaseChar;
import ru.omsu.base.properties.Properties;
import ru.omsu.reader.dom_parser.DomXmlParser;
import ru.omsu.reader.xml.IReaderXML;

/**
 * The class stores the characters received from the stream
 * and the previous character.
 */
public class Memory implements BaseChar, Properties {
    private char prevSymbol;
    private char inputSymbol;
    private int lengthIndent;
    private String indent;
    private String newLine;
    private static final Logger logger = Logger.getLogger(Memory.class);
    IReaderXML readerXML;
    private static boolean createFlag = true;
    private static Memory memory;

    /**
     * Constructor.
     */
    private Memory() {
        prevSymbol = 'n';
        inputSymbol = 'n';
        readerXML = new DomXmlParser("src/main/resources/config.xml");
        indent = "";

        if(readerXML.getDocument() == null) {
            lengthIndent = 4;
            newLine = "\n";
            logger.warn("Xml document is not find! Using standard configuration");
        }
        else {
            if (readerXML.getChildValue("system").equals("Windows")) {
                newLine = "\r\n";
            } else if (readerXML.getChildValue("system").equals("Linux")) {
                newLine = "\n";
            }

            lengthIndent = Integer.parseInt(readerXML.getChildValue("indent"));
        }
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return new instance of class MEMORY.
     */
    public static Memory onCreate() {
        if(createFlag) {
            createFlag = false;
            return memory = new Memory();
        } else {
            return memory;
        }
    }

    /**
     * Getter.
     * @return the string - indent.
     */
    public String getIndent() {
        return indent;
    }

    /**
     * Getter.
     * @return the character - new line.
     */
    public String getNewLine() {
        return newLine;
    }

    /**
     * Getter.
     * @return the length of string - indent.
     */
    public int getLengthIndent() {
        return lengthIndent;
    }

    /**
     * Increase the string - indent.
     */
    public void increaseIndent() {
        for(int i = 0; i < lengthIndent; ++i) {
            indent += " ";
        }
    }

    /**
     * Reduce the string - indent.
     */
    public void reduceIndent() {
        indent = indent.substring(0, indent.length() - lengthIndent);
    }

    /**
     * Getter.
     * @return previous character from stream.
     */
    public char getPrevSymbol() {
        return prevSymbol;
    }

    /**
     * Getter.
     * @return incoming character from stream.
     */
    public char getInputSymbol() {
        return inputSymbol;
    }

    /**
     * Setter.
     * Changes the value - inputSymbol on the value of the input parameter.
     * Changes the value - prevSymbol on value - inputSymbol.
     * @param inputSymbol
     */
    public void setInputSymbol(char inputSymbol) {
        prevSymbol = this.inputSymbol;
        this.inputSymbol = inputSymbol;
    }
}
