package ru.omsu.formatted.format;


import ru.omsu.base.memory.Memory;

/**
 * IFormatChar - Interface for formats character.
 */
public interface IFormatChar {

    /**
     * formatter(BaseInput) - Method formats incoming character.
     * @param memory
     * @return
     */
    public String formatter(Memory memory);
}
