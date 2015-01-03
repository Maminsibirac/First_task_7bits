package ru.omsu.formatted.inline_comments;

import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;


public class InlineComments implements IFormatChar {
    private char comments;
    private static boolean createFlag = true;
    private static InlineComments inlineComments;


    private InlineComments() {
        comments = '/';
    }

    public static InlineComments onCreate() {
        if(createFlag) {
            createFlag = false;
            return inlineComments = new InlineComments();
        } else {
            return inlineComments;
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
