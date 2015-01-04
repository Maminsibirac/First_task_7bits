package ru.omsu.formatted.semicolon;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats a symbol - semicolon.
 */
public class SemicolonFormat implements IFormatChar {
    private final  char semicolon;
    private static boolean createFlag = true;
    private static SemicolonFormat semicolonFormat;

    /**
     * Constructor.
     */
    private SemicolonFormat(){
        semicolon = ';';
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class SemicolonFormat.
     */
    public static SemicolonFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return semicolonFormat = new SemicolonFormat();
        } else {
            return semicolonFormat;
        }
    }

    /**
     * Compares specified symbol with an incoming parameter.
     * @param semicolon
     * @return true, if specified symbol and incoming parameter equal, else false.
     */
    public  boolean equalsChar(char semicolon) {
        if(semicolon == this.semicolon) {
            return true;
        }

        return false;
    }

    /**
     * Formats incoming symbol, if that is semicolon.
     * @return if incoming symbol is semicolon then result concatenation:
     * incoming symbol, symbol a newline and indent,
     * if program in condition code, else incoming symbol.
     * Else empty string.
     */
    public String formatter(Memory memory) {
        char inputSymbol = memory.getInputSymbol();
        Conditions conditions = Conditions.onCreate();
        StringBuilder result;

        if (equalsChar(inputSymbol)) {
            if(conditions.isCode() || conditions.isBlockComments()) {
                result = new StringBuilder(1 + memory.getNewLine().length());
                result.append(";" + memory.getNewLine() + memory.getIndent());
                return result.toString();
            }
            else {
                return Character.toString(inputSymbol);
            }
        }

        return "";
    }
}
