package ru.omsu.formatted.format;


import ru.omsu.base.memory.Memory;

/**
 * Interface for formats character.
 */
public interface IFormatChar {

    /**
     * Formats incoming character.
     * @param memory
     * @return formatted string.
     */
    public String formatter(Memory memory);
}
