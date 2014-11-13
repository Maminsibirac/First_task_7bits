package ru.omsu.formatted.format;


import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;

/**
 * IFormatChar - Interface for formats character.
 */
public interface IFormatChar {
    /**
     * formatter(BaseInput) - Method formats incoming character.
     * @param baseInput
     * @return
     */
    public String formatter(BaseInput baseInput, BaseProperties baseProperties);
}
