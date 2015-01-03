package ru.omsu.formatted.semicolon;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * SemicolonFormat - The class formats a character 'semicolon'.
 * Implements an interface IFormatChar.
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
     * onCreate() - Static method to create a new instance of the class SemicolonFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
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
     * equalsChar(char) - Method checks whether the incoming character is a 'semicolon'.
     * If return 'true' - yes.
     * If return 'false' - no.
     * @param symbol
     * @return
     */
    public  boolean equalsChar(char symbol) {
        if(symbol == semicolon) {
            return true;
        }

        return false;
    }

    /**
     * formatter(BaseInput, String) - Method formats incoming character, if that is 'space'.
     * Second param is string, defines a new line.

     * @return
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
