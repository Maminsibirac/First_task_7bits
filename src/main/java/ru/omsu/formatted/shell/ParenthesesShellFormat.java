package ru.omsu.formatted.shell;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.format.IFormatChar;
import ru.omsu.formatted.parentheses.left.ParenthesisLeftFormat;
import ru.omsu.formatted.parentheses.right.ParenthesisRightFormat;
import ru.omsu.formatted.semicolon.SemicolonFormat;

/**
 * ParenthesesShellFormat - The class shell, comprise formats character: 'parenthesis left',
 * 'parenthesis right' and 'semicolon'.
 * Implements an interface IFormatChar.
 */
public class ParenthesesShellFormat implements IFormatChar {
    private static ParenthesesShellFormat parenthesesShellFormat;
    private boolean parenthesisRightFlag = false;
    private ParenthesisLeftFormat parenthesisLeft;
    private ParenthesisRightFormat parenthesisRight;
    private SemicolonFormat semicolon;
    private static boolean createFlag = true;

    /**
     * Constructor.
     */
    private ParenthesesShellFormat() {
        parenthesisLeft = ParenthesisLeftFormat.onCreate();
        parenthesisRight = ParenthesisRightFormat.onCreate();
        semicolon = SemicolonFormat.onCreate();
    }

    /**
     * onCreate() - Static method to create a new instance of the class ParenthesesShellFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
     */
    public static ParenthesesShellFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return parenthesesShellFormat = new ParenthesesShellFormat();
        } else {
            return parenthesesShellFormat;
        }
    }

    /**
     * equalsChar(char) - Method checks whether the incoming character is a 'parenthesis left',
     * 'parenthesis right' and 'semicolon'.
     * If return 'true' - yes.
     * If return 'false' - no.
     * @param symbol
     * @return
     */
    public  boolean equalsChar(char symbol) {
        if(parenthesisLeft.equalsChar(symbol) || parenthesisRight.equalsChar(symbol) || semicolon.equalsChar(symbol)) {
            return true;
        }

        return false;
    }

    /**
     * formatter(BaseInput) - Method formats incoming character, if that are 'parenthesis left',
     * 'parenthesis right' or 'semicolon'.
     * @param baseInput
     * @return
     */
    public String formatter(BaseInput baseInput, BaseProperties baseProperties) {

        StringBuilder result;
        if(parenthesisLeft.equalsChar(baseInput.getInputSymbol())) {
            result = new StringBuilder();
            parenthesisRightFlag = true;
            result.append(parenthesisLeft.formatter(baseInput, baseProperties));
            return result.toString();


        } else if(parenthesisRight.equalsChar(baseInput.getInputSymbol())) {
            result = new StringBuilder();
            parenthesisRightFlag = false;
            result.append(parenthesisRight.formatter(baseInput, baseProperties));
            return result.toString();

        }

        if(semicolon.equalsChar(baseInput.getInputSymbol())) {
            result = new StringBuilder();
            if (parenthesisRightFlag) {
                result.append(semicolon.formatter(baseInput, baseProperties));

            } else {
                result.append(semicolon.formatter(baseInput, baseProperties));
            }

            return result.toString();
        }

        return "";
    }
}
