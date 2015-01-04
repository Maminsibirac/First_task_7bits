package ru.omsu.reader.string;


import ru.omsu.reader.stream.IReaderStream;

/**
 * The class read string.
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
     * Inform whether there is in string next symbol.
     * @return true, if you can read symbol from the stream, else false.
     */
    public boolean hasNextValue() {
        if(index >= text.length())
            return false;
        else
            return true;
    }

    /**
     * Read next symbol in file string.
     * @return symbol received from stream.
     */
    public char readNextValue() {
        return text.charAt(index++);
    }
}
