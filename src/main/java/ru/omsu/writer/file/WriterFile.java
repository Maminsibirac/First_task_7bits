package ru.omsu.writer.file;


import org.apache.log4j.Logger;
import ru.omsu.writer.stream.IWriterStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * WriterFile - The class writes a string to a stream.
 * Implements an interface IWriterStream.
 */
public class WriterFile implements IWriterStream {
    private static final Logger logger = Logger.getLogger(WriterFile.class);
    private File file;
    private RandomAccessFile rFile;

    /**
     * Constructor(String).
     * @param fileName
     */
    public WriterFile(String fileName) {
        try {
            file = new File(fileName);
            if(file.exists()) {
                rFile = new RandomAccessFile(file, "rw");
            }
            else throw new FileNotFoundException();
        } catch(FileNotFoundException e) {
            logger.error(e);
        }
    }

    /**
     * getFile() - Method return value file.
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     * existsFile(File) - Method checks the existence of the file.
     * @return
     */
    public boolean existsFile() {
        if(file.exists()) {
            return true;
        }

        return false;
    }

    /**
     * writeFile() - Method write string to a file.
     * @param text
     */
    public void writeValue(String text) {
        try {
            rFile.skipBytes((int)file.length());
            rFile.writeBytes(text);

        } catch (IOException e) {
            logger.error(e);
        }
    }

    /**
     * writeClose() - Method to close the stream for write.
     * @return
     */
    public boolean writeClose() {
        try {
            rFile.close();
        } catch(IOException e) {
            logger.warn(e);
        }

        return true;
    }
}
