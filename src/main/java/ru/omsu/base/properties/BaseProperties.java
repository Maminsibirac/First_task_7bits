package ru.omsu.base.properties;

import ru.omsu.reader.xml.IReaderXML;

/**
 * BaseProperties - The class stores configuration of the program.
 */
public class BaseProperties {
    private int lengthIndent;
    private String indent;
    private String newLine;

    /**
     * getIndent() - Method returns the string 'indent'.
     * @return
     */
    public String getIndent() {
        return indent;
    }

    /**
     * getNewLine() - Method returns the character 'new line'.
     * @return
     */
    public String getNewLine() {
        return newLine;
    }

    /**
     * getLengthIndent() - Method returns the length of string 'indent'.
     * @return
     */
    public int getLengthIndent() {
        return lengthIndent;
    }

    /**
     * increaseIndent() - Method increase the string 'indent'.
     */
    public void increaseIndent() {
        for(int i = 0; i < lengthIndent; ++i) {
            indent += " ";
        }
    }

    /**
     * reduceIndent() - Method reduce the string 'indent'.
     */
    public void reduceIndent() {
        indent = indent.substring(0, indent.length() - lengthIndent);
    }

    /**
     * Constructor.
     * @param readerXML
     */
    public BaseProperties(IReaderXML readerXML) {
        indent = "";

        if(readerXML.getDocument() == null) {
            lengthIndent = 4;
            newLine = "\n";
        }
        else {
            if(readerXML.getChildValue("system").equals("Windows")) {
                newLine = "\r\n";
            }
            else if(readerXML.getChildValue("system").equals("Linux")) {
                newLine = "\n";
            }

            lengthIndent = Integer.parseInt(readerXML.getChildValue("indent"));
        }
    }
}
