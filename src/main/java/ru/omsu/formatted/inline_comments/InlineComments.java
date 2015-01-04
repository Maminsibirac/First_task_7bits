package ru.omsu.formatted.inline_comments;

import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats a comments, which in one line.
 */
public class InlineComments implements IFormatChar {
    private char comments;
    private static boolean createFlag = true;
    private static InlineComments inlineComments;

    /**
     * Constructor.
     */
    private InlineComments() {
        comments = '/';
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class InlineComments.
     */
    public static InlineComments onCreate() {
        if(createFlag) {
            createFlag = false;
            return inlineComments = new InlineComments();
        } else {
            return inlineComments;
        }
    }

    /**
     * Compares specified symbol with an incoming parameter.
     * @param comments
     * @return true, if specified symbol and incoming parameter equal, else false.
     */
    public  boolean equalsChar(char comments) {
        if(comments == this.comments) {
            return true;
        }

        return false;
    }

    /**
     * Sets the state in which program handles a comment,
     * if this comments in one line.
     * @param memory
     * @return if incoming symbols and prev symbol is forward slash:
     * incoming symbol if program in begin comment, or result concatenation:
     * incoming symbols and indent, if program in end comment.
     * if incoming symbol is not forward slash then empty string.
     */
    public String formatter(Memory memory) {
        char inputSymbol = memory.getInputSymbol();
        char prevSymbol = memory.getPrevSymbol();
        Conditions conditions = Conditions.onCreate();

        if((equalsChar(inputSymbol) && equalsChar(prevSymbol))) {
            conditions.setCode(false);
            conditions.setInlineComments(true);
            return Character.toString(inputSymbol);
        }

        if(inputSymbol == '\n') {
            if (conditions.isInlineComments()) {
                conditions.setCode(true);
                conditions.setInlineComments(false);
                return inputSymbol + memory.getIndent();
            }
        }

        return "";
    }
}
