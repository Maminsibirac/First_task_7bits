package ru.omsu.formatted.single_quotes;

import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats a character constants.
 */
public class SingleQuotesFormat implements IFormatChar{
    private char quotes;
    private static boolean createFlag = true;
    private static SingleQuotesFormat singleQuotesFormat;

    /**
     * Constructor.
     */
    private SingleQuotesFormat() {
        quotes = '\'';
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class SingleQuotesFormat.
     */
    public static SingleQuotesFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return singleQuotesFormat = new SingleQuotesFormat();
        } else {
            return singleQuotesFormat;
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
     * Sets the state in which program handles a character constants.
     * @param memory
     * @return if incoming symbol is single quote then his, else empty string.
     */
    public String formatter(Memory memory) {
        char inputSymbol = memory.getInputSymbol();
        Conditions conditions = Conditions.onCreate();

        if(equalsChar(inputSymbol)) {
            if(conditions.isStringSingleQuotes()) {
                conditions.setStringSingleQuotes(false);
                if(!conditions.isStringDoubleQuotes() && !conditions.isInlineComments()
                        && !conditions.isBlockComments()) {
                    conditions.setCode(true);
                }
            }
            else {
                conditions.setCode(false);
                conditions.setStringSingleQuotes(true);
            }
            return Character.toString(inputSymbol);
        }

        return "";
    }
}
