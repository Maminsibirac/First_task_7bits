package ru.omsu.reader.stream;

/**
 * IReaderStream - Interface for reading a character in some stream.
 */
public interface IReaderStream {
    /**
     * existsFile() - Method checks the existence of the file.
     * @return
     */
    public boolean existsFile();

    /**
     * hasNextValue() - Method inform whether there is in stream next character.
     * @return
     */
    public boolean hasNextValue();

    /**
     * readNextValue() - Method read next character in file stream.
     * @return
     */
    public char readNextValue();
}
