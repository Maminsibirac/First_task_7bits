package ru.omsu.formatted.space;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.format.IFormatChar;

/**
 * SpaceFormat - The class formats the character 'space'.
 * Implements an interface IFormatChar.
 */
public class SpaceFormat implements IFormatChar {
    private static SpaceFormat spaceFormat;
    private final char name;
    private static boolean createFlag = true;

    /**
     * Constructor.
     */
    private SpaceFormat() {
        name = ' ';
    }

    /**
     * onCreate() - Static method to create a new instance of the class SpaceFormat.
     * onCreate() must create only one instance.
     * If instance is create, then method return reference to an instance.
     * @return
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
     * equalsChar(char) - Method checks whether the incoming character is a 'space'.
     * If return 'true' - yes.
     * If return 'false' - no.
     * @param symbol
     * @return
     */
    public boolean equalsChar(char symbol) {
        if(symbol == name) {
            return true;
        }

        return false;
    }

    /**
     * formatter(BaseInput) - Method formats incoming character, if that is 'space'.
     * @param baseData
     * @return
     */
    public String formatter(BaseInput baseData, BaseProperties baseProperties) {
        char prevSymbol = baseData.getPrevSymbol();
        char inputSymbol = baseData.getInputSymbol();
        StringBuilder result = new StringBuilder();

        if(equalsChar(inputSymbol)) {
            if (prevSymbol != ';' && prevSymbol != ' ' && prevSymbol != 'n'
                    && prevSymbol != '}' && prevSymbol != '{' && prevSymbol != '\n' && prevSymbol != '(') {
                result.append(inputSymbol);

                return  result.toString();
            }
        }

        return "";
    }
}
