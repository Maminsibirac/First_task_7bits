package ru.omsu.formatted.parentheses.left;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.format.IFormatChar;

/**
 * ParenthesisLeftFormat - The class formats a character 'parenthesis left'.
 * Implements an interface IFormatChar.
 */
public class ParenthesisLeftFormat implements IFormatChar {
    private final char paranthesisLeft;
    private static boolean createFlag = true;
    private static ParenthesisLeftFormat parenthesisLeftFormat;

    /**
     * Constructor.
     */
    private ParenthesisLeftFormat(){
        paranthesisLeft = '(';
    }

    /**
     * onCreate() - Static method to create a new instance of the class ParenthesisLeftFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
     */
    public static ParenthesisLeftFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return parenthesisLeftFormat = new ParenthesisLeftFormat();
        } else {
            return parenthesisLeftFormat;
        }
    }

    /**
     * equalsChar(char) - Method checks whether the incoming character is a 'parenthesis left'.
     * If return 'true' - yes.
     * If return 'false' - no.
     * @param symbol
     * @return
     */
    public boolean equalsChar(char symbol) {
        if(symbol == paranthesisLeft) {
            return true;
        }

        return false;
    }

    /**
     * formatter(BaseInput) - Method formats incoming character, if that is 'parenthesis left'.
     * @param baseInput
     * @return
     */
    public String formatter(BaseInput baseInput, BaseProperties baseProperties) {

        if(equalsChar(baseInput.getInputSymbol())) {
            StringBuilder result = new StringBuilder(1);
            result.append(baseInput.getInputSymbol());
            return result.toString();
        }

        return "";
    }
}
