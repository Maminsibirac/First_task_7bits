package ru.omsu.reader.file;

import org.apache.log4j.Logger;
import ru.omsu.reader.stream.IReaderStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The class read a character from file stream.
 */
public class ReaderFile implements IReaderStream{
    private static final Logger logger = Logger.getLogger(ReaderFile.class);
    private int poison;
    private File file;
    private RandomAccessFile bufFile;

    /**
     * Constructor.
     * @param fileName
     */
    public ReaderFile(String fileName) {
        poison = 0;

        try {
            file = new File(fileName);
            bufFile = new RandomAccessFile(file ,"r");

        } catch (FileNotFoundException e) {
            logger.error(e);
        }
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
     * Inform whether there is in stream next symbol.
     * @return true, if you can read symbol from the stream, else false.
     */
    public boolean hasNextValue() {
        if ((file.length() - poison) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Read next symbol in file stream.
     * @return symbol received from stream.
     */
    public char readNextValue() {
        byte buf[] = new byte[1];

        try {
            bufFile.seek(poison);
            bufFile.read(buf);
            poison += 1;

            if (!hasNextValue()) {
                bufFile.close();
            }

        } catch(IOException e) {
            logger.error(e);
        }

        char result = (char)buf[0];
        return result;
    }
}
