package ru.omsu.formatted.indent;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
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
     * @param memory
     * @return
     */
    public String formatter(Memory memory) {
        char prevSymbol = memory.getPrevSymbol();
        char inputSymbol = memory.getInputSymbol();
        Conditions conditions = Conditions.onCreate();
        StringBuilder result;

        if(inputSymbol == '{' || inputSymbol == '}') {
            if(conditions.isCode() || conditions.isBlockComments()) {
                result = new StringBuilder();
                if (inputSymbol == '{') {
                    if (prevSymbol != ' ') {
                        result.append(' ');
                    }

                    memory.increaseIndent();
                    memory.setInputSymbol(' ');
                    return result.append(inputSymbol + memory.getNewLine() + memory.getIndent()/*indent*/).toString();
                } else if (inputSymbol == '}') {
                    memory.reduceIndent();
                    memory.setInputSymbol(' ');

                    return result.append(memory.getNewLine() + memory.getIndent() + inputSymbol +
                            memory.getNewLine() + memory.getIndent()).toString();
                }
            }
            else {
                return Character.toString(inputSymbol);
            }
        }
        return "";
    }
}
