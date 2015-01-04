package ru.omsu.formatted.double_quotes;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats a string.
 */
public class DoubleQuotesFormat implements IFormatChar {
    private char quotes;
    private static boolean createFlag = true;
    private static DoubleQuotesFormat doubleQuotesFormat;

    /**
     * Constructor.
     */
    private DoubleQuotesFormat() {
        quotes = '"';
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class DoubleQuotesFormat.
     */
    public static DoubleQuotesFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return doubleQuotesFormat = new DoubleQuotesFormat();
        } else {
            return doubleQuotesFormat;
        }
    }

    /**
     * Compares specified symbol with an incoming parameter.
     * @param quotes
     * @return true, if specified symbol and incoming parameter equal, else false.
     */
    public  boolean equalsChar(char quotes) {
        if(quotes == this.quotes) {
            return true;
        }

        return false;
    }

    /**
     * Sets the state in which program handles a string.
     * @param memory
     * @return if incoming symbol is double quote then his, else empty string.
     */
    public String formatter(Memory memory) {
        char inputSymbol = memory.getInputSymbol();
        Conditions conditions = Conditions.onCreate();

        if(equalsChar(inputSymbol)) {
            if(conditions.isStringDoubleQuotes()) {
                conditions.setStringDoubleQuotes(false);
                if(!conditions.isStringSingleQuotes() && !conditions.isInlineComments()
                        && !conditions.isBlockComments()) {
                    conditions.setCode(true);
                }
            }
            else {
                conditions.setCode(false);
                conditions.setStringDoubleQuotes(true);
            }
            return Character.toString(inputSymbol);
        }

        return "";
    }
}
