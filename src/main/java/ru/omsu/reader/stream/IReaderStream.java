package ru.omsu.reader.stream;

/**
 * Interface for reading a character in some stream.
 */
public interface IReaderStream {

    /**
     * Inform whether there is in stream next symbol.
     * @return true, if you can read symbol from the stream, else false.
     */
    public boolean hasNextValue();

    /**
     * Read next character in file stream.
     * @return symbol received from stream.
     */
    public char readNextValue();
}
