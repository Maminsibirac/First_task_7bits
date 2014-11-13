package ru.omsu.formatted.semicolon;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
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
     * formatter(BaseInput) - Method formats incoming character, if that is 'semicolon'.
     * @param baseData
     * @return
     */
    public String formatter(BaseInput baseData, String newLine) {
        char inputSymbol = baseData.getInputSymbol();
        StringBuilder result;

        if (equalsChar(inputSymbol)) {
            result = new StringBuilder(3);
            result.append(";" + newLine);
            return result.toString();
        }

        return "";
    }

    /**
     * formatter(BaseInput, String) - Method formats incoming character, if that is 'space'.
     * Second param is string, defines a new line.
     * @param baseData
     * @param baseProperties
     * @return
     */
    public String formatter(BaseInput baseData, BaseProperties baseProperties) {
        char inputSymbol = baseData.getInputSymbol();
        StringBuilder result;

        if (equalsChar(inputSymbol)) {
            result = new StringBuilder(1 + baseProperties.getNewLine().length());
            result.append(";" + baseProperties.getNewLine() + baseProperties.getIndent());
            return result.toString();
        }

        return "";
    }
}
