package ru.omsu.writer.stream;

import ru.omsu.reader.stream.IReaderStream;

/**
 * Interface for writing a string in some stream.
 */
public interface IWriterStream {

    /**
     * Write string to a file.
     * @param text
     */
    public void writeValue(String text, IReaderStream readerStream);

}
