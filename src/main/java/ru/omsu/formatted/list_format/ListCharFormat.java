package ru.omsu.formatted.list_format;

import ru.omsu.formatted.format.IFormatChar;
import ru.omsu.formatted.indent.IndentFormat;
import ru.omsu.formatted.shell.ParenthesesShellFormat;
import ru.omsu.formatted.space.SpaceFormat;

import java.util.ArrayList;


public class ListCharFormat {
    private ArrayList<IFormatChar> listFormat;

    /**
     * Constructor.
     */
    public ListCharFormat() {
        listFormat = new ArrayList<IFormatChar>();

        listFormat.add(SpaceFormat.onCreate());
        listFormat.add(ParenthesesShellFormat.onCreate());
        listFormat.add(IndentFormat.onCreate());
    }

    /**
     * getListFormat() - Method return value listFormat.
     * @return
     */
    public ArrayList<IFormatChar> getListFormat() {
        return listFormat;
    }
}
