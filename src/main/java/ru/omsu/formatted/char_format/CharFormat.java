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

    public static CharFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return charFormat = new CharFormat();
        } else {
            return charFormat;
        }
    }

    /**
     * getFormat() - Method return value listFormat.
     * @return
     */
    public ArrayList<IFormatChar> getFormat() {
        return listFormat;
    }
}
