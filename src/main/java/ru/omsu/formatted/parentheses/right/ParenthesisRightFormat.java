package ru.omsu.formatted.parentheses.right;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.format.IFormatChar;

/**
 * ParenthesisLeftFormat - The class formats a character 'parenthesis right'.
 * Implements an interface IFormatChar.
 */
public class ParenthesisRightFormat implements IFormatChar {
    private final char parenthesisRigth;
    private static boolean createFlag = true;
    private static ParenthesisRightFormat parenthesisRightFormat;

    /**
     * Constructor.
     */
    private ParenthesisRightFormat(){
        parenthesisRigth = ')';
    }

    /**
     * onCreate() - Static method to create a new instance of the class ParenthesisRightFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
     */
    public static ParenthesisRightFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return parenthesisRightFormat = new ParenthesisRightFormat();
        } else {
            return parenthesisRightFormat;
        }
    }

    /**
     * equalsChar(char) - Method checks whether the incoming character is a 'parenthesis right'.
     * If return 'true' - yes.
     * If return 'false' - no.
     * @param symbol
     * @return
     */
    public boolean equalsChar(char symbol) {
        if(symbol == parenthesisRigth) {
            return true;
        }

        return false;
    }

    /**
     * formatter(BaseInput) - Method formats incoming character, if that is 'parenthesis right'.
     * @param baseInput
     * @return
     */
    public String formatter(BaseInput baseInput, BaseProperties baseProperties) {
        if(equalsChar(baseInput.getInputSymbol())) {
            StringBuilder result = new StringBuilder();
            result.append(baseInput.getInputSymbol());
            return result.toString();
        }

        return "";
    }
}
