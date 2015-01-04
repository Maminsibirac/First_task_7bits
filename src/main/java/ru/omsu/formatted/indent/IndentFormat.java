package ru.omsu.formatted.indent;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats a symbol - braces.
 */
public class IndentFormat implements IFormatChar {
    private static boolean createFlag = true;
    private static IndentFormat indentFormat;

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class IndentFormat.
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
     * Formats incoming symbol, if that is left brace or right brace.
     * @param memory
     * @return if incoming symbol is right or left brace then formatted string,
     * else empty string.
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
                } else {
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
