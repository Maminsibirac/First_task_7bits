package ru.omsu.formatter_code;

import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.char_format.CharFormat;
import ru.omsu.reader.stream.IReaderStream;
import ru.omsu.writer.stream.IWriterStream;

/**
 * FormatterJavaCode - The class s formats Java code. (No format character 'Tab' and more... =))
 */
public class FormatterJavaCode {

    /**
     * formatter(IReaderStream readerStream, IWriterStream writerStream) - Method
     * formats character by character who came to the processing object.
     *
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
