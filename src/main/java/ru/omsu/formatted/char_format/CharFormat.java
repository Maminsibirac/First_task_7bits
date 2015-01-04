package ru.omsu.formatted.char_format;

import ru.omsu.base.conditions.Conditions;
import ru.omsu.formatted.block_comments.BlockComments;
import ru.omsu.formatted.double_quotes.DoubleQuotesFormat;
import ru.omsu.formatted.format.IFormatChar;
import ru.omsu.formatted.indent.IndentFormat;
import ru.omsu.formatted.inline_comments.InlineComments;
import ru.omsu.formatted.semicolon.SemicolonFormat;
import ru.omsu.formatted.single_quotes.SingleQuotesFormat;
import ru.omsu.formatted.space.SpaceFormat;

import java.util.ArrayList;

/**
 * Works with all handlers that are used in the program.
 */
public class CharFormat {
    private ArrayList<IFormatChar> listFormat;
    private static boolean createFlag = true;
    private static CharFormat charFormat;
    Conditions conditions;

    /**
     * Constructor.
     */
    private CharFormat() {
        listFormat = new ArrayList<IFormatChar>();
        conditions = Conditions.onCreate();

        listFormat.add(SpaceFormat.onCreate());
        listFormat.add(SemicolonFormat.onCreate());
        listFormat.add(IndentFormat.onCreate());
        listFormat.add(SingleQuotesFormat.onCreate());
        listFormat.add(DoubleQuotesFormat.onCreate());
        listFormat.add(InlineComments.onCreate());
        listFormat.add(BlockComments.onCreate());
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class CharFormat.
     */
    public static CharFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return charFormat = new CharFormat();
        } else {
            return charFormat;
        }
    }

    /**
     * Getter.
     * @return value listFormat.
     */
    public ArrayList<IFormatChar> getFormat() {
        return listFormat;
    }
}
