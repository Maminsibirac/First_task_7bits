package ru.omsu.formatted.another_char;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.format.IFormatChar;

/**
 * AnotherCharFormat - The class formats a characters 'braces'.
 * Implements an interface IFormatChar.
 */
public class AnotherCharFormat implements IFormatChar {
    private static boolean createFlag = true;
    private static AnotherCharFormat anotherCharFormat;

    /**
     * Constructor.
     */
    private AnotherCharFormat(){}

    /**
     * onCreate() - Static method to create a new instance of the class AnotherCharFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
     */
    public static AnotherCharFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return anotherCharFormat = new AnotherCharFormat();
        } else {
            return anotherCharFormat;
        }
    }

    /**
     * equalsChar(char) - Method checks whether the incoming character.
     * If return 'true' - yes.
     * If return 'false' - no.
     * @param symbol
     * @return
     */
    public static boolean equalsChar(char symbol) {
        if(symbol != ' ' && symbol != '\n' && symbol != ';' && symbol != '{' && symbol != '}'
                && symbol != '(' && symbol != ')') {
            return true;
        }

        return false;
    }

    /**
     * formatter(BaseInput) - Method formats incoming character.
     * @param baseInput
     * @return
     */
    public String formatter(BaseInput baseInput, BaseProperties baseProperties) {
        char inputSymbol = baseInput.getInputSymbol();
        StringBuilder s;

        if(equalsChar(inputSymbol)) {
            s = new StringBuilder();
            s.append(inputSymbol);
            return s.toString();
        }

        return "";
    }
}
