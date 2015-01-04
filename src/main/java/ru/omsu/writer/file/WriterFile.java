package ru.omsu.writer.file;


import org.apache.log4j.Logger;
import ru.omsu.reader.stream.IReaderStream;
import ru.omsu.writer.stream.IWriterStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The class writes a string to a stream.
 */
public class WriterFile implements IWriterStream {
    private static final Logger logger = Logger.getLogger(WriterFile.class);
    private File file;
    private RandomAccessFile rFile;

    /**
     * Constructor.
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
     * Getter.
     * @return pointer to a file.
     */
    public File getFile() {
        return file;
    }

    /**
     * Checks the existence of the file.
     * @return true, if the file exists, else false.
     */
    public boolean existsFile() {
        if(file.exists()) {
            return true;
        }

        return false;
    }

    /**
     * Write string to a file.
     * @param text
     */
    public void writeValue(String text, IReaderStream readerStream) {
        try {
            rFile.skipBytes((int)file.length());
            rFile.writeBytes(text);

        } catch (IOException e) {
            logger.error(e);
        }

        try {
            if(!readerStream.hasNextValue()) {
                rFile.close();
            }
        } catch(IOException e) {
            logger.warn(e);
        }
    }

}
