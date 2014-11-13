package ru.omsu.reader.file;

import org.apache.log4j.Logger;
import ru.omsu.reader.stream.IReaderStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ReaderFile - The class read a character from file stream.
 * Implements an interface IReaderStream.
 */
public class ReaderFile implements IReaderStream{
    private static final Logger logger = Logger.getLogger(ReaderFile.class);
    private int poison;
    private File file;
    private RandomAccessFile bufFile;

    /**
     * Constructor(String).
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
     * hasNextValue() - Method inform whether there is in stream next character.
     * If he return 'true' - character there is.
     * If he return 'false' - character isn't there.
     * @return
     */
    public boolean hasNextValue() {
        if ((file.length() - poison) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * readNextValue() - Method read next character in file stream.
     * @return
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
