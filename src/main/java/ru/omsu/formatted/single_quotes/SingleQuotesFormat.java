package ru.omsu.formatted.single_quotes;


import ru.omsu.base.conditions.Conditions;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

public class SingleQuotesFormat implements IFormatChar{
    private char quotes;
    private static boolean createFlag = true;
    private static SingleQuotesFormat singleQuotesFormat;


    private SingleQuotesFormat() {
        quotes = '\'';
    }

    public static SingleQuotesFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return singleQuotesFormat = new SingleQuotesFormat();
        } else {
            return singleQuotesFormat;
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
            if(conditions.isStringSingleQuotes()) {
                conditions.setStringSingleQuotes(false);
                if(!conditions.isStringDoubleQuotes() && !conditions.isInlineComments()
                        && !conditions.isBlockComments()) {
                    conditions.setCode(true);
                }
            }
            else {
                conditions.setCode(false);
                conditions.setStringSingleQuotes(true);
            }
            return Character.toString(inputSymbol);
        }

        return "";
    }
}
