package ru.omsu.formatted.space;

import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.format.IFormatChar;

/**
 * The class formats the symbol - space.
 *
 */
public class SpaceFormat implements IFormatChar {
    private static SpaceFormat spaceFormat;
    private final char space;
    private static boolean createFlag = true;

    /**
     * Constructor.
     */
    private SpaceFormat() {
        space = ' ';
    }

    /**
     * Create an instance of class.
     * Monitors that there has always been one instance of the class.
     * @return the new instance of class SpaceFormat.
     */
    public static SpaceFormat onCreate() {
        if(createFlag) {
            createFlag = false;
            return spaceFormat = new SpaceFormat();
        } else {
            return spaceFormat;
        }
    }

    /**
     * Compares specified symbol with an incoming parameter.
     * @param space
     * @return true, if specified symbol and incoming parameter equal, else false.
     */
    public boolean equalsChar(char space) {
        if(space== this.space) {
            return true;
        }

        return false;
    }

    /**
     * Formats incoming symbol, if that is space.
     * @return if incoming symbol is space then his, else empty string.
     */
    public String formatter(Memory memory) {
        char prevSymbol = memory.getPrevSymbol();
        char inputSymbol = memory.getInputSymbol();

        if(equalsChar(inputSymbol)) {

            if (prevSymbol != ' ' && prevSymbol != 'n'
                    && prevSymbol != '}' && prevSymbol != '{' && prevSymbol != '\n'
                        && prevSymbol != '(') {

                return " ";
            }

        }

        return "";
    }
}
