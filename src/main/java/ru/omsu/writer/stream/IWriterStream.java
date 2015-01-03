package ru.omsu.writer.stream;

import ru.omsu.reader.stream.IReaderStream;

/**
 * IWriterStream - Interface for writing a string in some stream.
 */
public interface IWriterStream {
    /**
     * existsFile(File) - Method checks the existence of the file.
     * @return
     */
    public boolean existsFile();

    /**
     * writeFile - Method write string to a file.
     * @param text
     */
    public void writeValue(String text, IReaderStream readerStream);

}
