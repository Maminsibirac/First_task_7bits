package ru.omsu.exception;

/**
 * Exception, catches the null tag.
 */
public class NullTagValueException extends NullPointerException {
    private String detail;

    /**
     * Constructor.
     */
    public NullTagValueException(String e) {
        detail = e;
    }

    /**
     * Getter.
     * @return error message.
     */
    public String getMessageError(){
        return "NullTagValueException: " + detail;
    }
}
