package ru.omsu.formatted.indent;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.format.IFormatChar;

/**
 * IndentFormat - The class formats a characters 'braces'.
 * Implements an interface IFormatChar.
 */
public class IndentFormat implements IFormatChar {
    private static boolean createFlag = true;
    private static IndentFormat indentFormat;

    /**
     * onCreate() - Static method to create a new instance of the class IndentFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
     */
    public static IndentFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return indentFormat = new IndentFormat();
        } else {
            return indentFormat;
        }
    }

    /**
     * formatter(BaseInput) - Method formats incoming character, if that is 'brace left' or 'brace right'.
     * @param baseInput
     * @return
     */
    public String formatter(BaseInput baseInput, BaseProperties baseProperties) {
        char prevSymbol = baseInput.getPrevSymbol();
        char inputSymbol = baseInput.getInputSymbol();
        StringBuilder result;

        if(inputSymbol == '{') {
            result = new StringBuilder();

            if (prevSymbol != ' ') {
                result.append(' ');
            }

            baseProperties.increaseIndent();
            baseInput.setInputSymbol(' ');
            return result.append(inputSymbol + baseProperties.getNewLine() + baseProperties.getIndent()/*indent*/).toString();
        } else if(inputSymbol == '}') {
            result = new StringBuilder();
            baseProperties.reduceIndent();
            baseInput.setInputSymbol(' ');

            return result.append(baseProperties.getNewLine() + baseProperties.getIndent() + inputSymbol +
                    baseProperties.getNewLine() + baseProperties.getIndent()).toString();
        }

        return "";
    }
}
