package ru.omsu.reader.string;


import ru.omsu.reader.stream.IReaderStream;

/**
 * ReaderString - The class is unnecessary shell over String =)=)=).
 * ReaderString implements IReaderStream.
 */
public class ReaderString implements IReaderStream {
    private String text;
    private int index;

    /**
     * Constructor.
     * @param text
     */
    public ReaderString(String text) {
        this.text = text;
        index = 0;
    }

    /**
     * existsFile() - Method checks the existence of the file.
     * @return
     */
    public boolean existsFile() { return true; }

    /**
     * hasNextValue() - Method inform whether there is in string next character.
     * @return
     */
    public boolean hasNextValue() {
        if(index >= text.length())
            return false;
        else
            return true;
    }

    /**
     * readNextValue() - Method read next character in file string.
     * @return
     */
    public char readNextValue() {
        return text.charAt(index++);
    }
}
