package ru.omsu.formatted.block_comments;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

public class BlockComments implements IFormatChar {
    private char comments;
    private static boolean createFlag = true;
    private static BlockComments blockComments;


    private BlockComments() {
        comments = '/';
    }

    public static BlockComments onCreate() {
        if(createFlag) {
            createFlag = false;
            return blockComments = new BlockComments();
        } else {
            return blockComments;
        }
    }

    public  boolean equalsChar(char symbol) {
        if(symbol == comments) {
            return true;
        }

        return false;
    }

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
