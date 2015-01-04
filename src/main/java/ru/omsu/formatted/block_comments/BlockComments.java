package ru.omsu.formatted.block_comments;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats a comments, which occupies more than one line.
 */
public class BlockComments implements IFormatChar {
    private char comments;
    private static boolean createFlag = true;
    private static BlockComments blockComments;


    /**
     * Constructor.
     */
    private BlockComments() {
        comments = '/';
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return new instance of class BlockComments.
     */
    public static BlockComments onCreate() {
        if(createFlag) {
            createFlag = false;
            return blockComments = new BlockComments();
        } else {
            return blockComments;
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
     * if comment occupies more than one line.
     * @param memory
     * @return if incoming symbol is a forward slash and prev symbol is a asterisk
     * or incoming symbol is a asterisk and prev symbol is a forward slash then
     * result concatenation: incoming symbol, symbol newline and indent.
     * Else empty string.
     */
    public String formatter(Memory memory) {
        char inputSymbol = memory.getInputSymbol();
        char prevSymbol = memory.getPrevSymbol();
        Conditions conditions = Conditions.onCreate();

        if(equalsChar(prevSymbol) && inputSymbol == '*') {
            conditions.setCode(false);
            conditions.setBlockComments(true);

            return inputSymbol + memory.getNewLine() + memory.getIndent();
        } else if (equalsChar(inputSymbol) && prevSymbol == '*') {
            conditions.setCode(true);
            conditions.setBlockComments(false);

            return inputSymbol + memory.getNewLine() + memory.getIndent() ;
        }

        return "";
    }
}
