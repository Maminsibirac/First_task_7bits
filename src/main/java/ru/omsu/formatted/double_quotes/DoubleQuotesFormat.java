package ru.omsu.formatted.double_quotes;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

public class DoubleQuotesFormat implements IFormatChar {
    private char quotes;
    private static boolean createFlag = true;
    private static DoubleQuotesFormat doubleQuotesFormat;


    private DoubleQuotesFormat() {
        quotes = '"';
    }

    public static DoubleQuotesFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return doubleQuotesFormat = new DoubleQuotesFormat();
        } else {
            return doubleQuotesFormat;
        }
    }

    public  boolean equalsChar(char symbol) {
        if(symbol == quotes) {
            return true;
        }

        return false;
    }

    public String formatter(Memory memory) {
        char inputSymbol = memory.getInputSymbol();
        Conditions conditions = Conditions.onCreate();

        if(equalsChar(inputSymbol)) {
            if(conditions.isStringDoubleQuotes()) {
                conditions.setStringDoubleQuotes(false);
                if(!conditions.isStringSingleQuotes() && !conditions.isInlineComments()
                        && !conditions.isBlockComments()) {
                    conditions.setCode(true);
                }
            }
            else {
                conditions.setCode(false);
                conditions.setStringDoubleQuotes(true);
            }
            return Character.toString(inputSymbol);
        }

        return "";
    }
}
