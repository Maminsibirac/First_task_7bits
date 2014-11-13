package ru.omsu.writer.stream;

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
    public void writeValue(String text);

    /**
     * writeClose - Method to close the stream for write.
     * @return
     */
    public boolean writeClose();
}
