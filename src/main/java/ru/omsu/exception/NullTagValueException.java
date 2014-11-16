package ru.omsu.exception;

/**
 * NullTagValueException - Exception, catches the null tag.
 * Use DomXmlParser.
 * NullTagValueException extends NullPointerException.
 */
public class NullTagValueException extends NullPointerException {
    private String detail;

    /**
     * Constructor.
     * @param e
     */
    public NullTagValueException(String e) {
        detail = e;
    }

    /**
     * getMessageError() - return error message.
     * @return
     */
    public String getMessageError(){
        return "NullTagValueException: " + detail;
    }
}
