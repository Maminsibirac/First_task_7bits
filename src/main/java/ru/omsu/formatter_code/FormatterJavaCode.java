package ru.omsu.formatter_code;

import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.char_format.CharFormat;
import ru.omsu.reader.stream.IReaderStream;
import ru.omsu.writer.stream.IWriterStream;

/**
 * The class s formats Java code.
 */
public class FormatterJavaCode {

    /**
     * Formats incoming stream.
     * @param readerStream
     * @param writerStream
     */
    public void formatter(IReaderStream readerStream, IWriterStream writerStream) {
        String text = "";

        while(readerStream.hasNextValue()) {
            text = charFormatter(readerStream);
            writerStream.writeValue(text, readerStream);
        }
    }

    /**
     * Formats incoming symbol.
     * @param readerStream
     * @return formatted symbol.
     */
    private String charFormatter(IReaderStream readerStream) {
        CharFormat charFormat = CharFormat.onCreate();
        int sizeListFormat = charFormat.getFormat().size();
        Memory memory = Memory.onCreate();
        char input;
        String text = "";

        memory.setInputSymbol(readerStream.readNextValue());
        input = memory.getInputSymbol();
        for (int index = 0; index < sizeListFormat; ++index) {
            text += charFormat.getFormat().get(index).formatter(memory);
        }

        if (text.isEmpty()) {
            if(input != '\n' && input != ' ') {
                text += input;
            }
        }

        return text;
    }
}
