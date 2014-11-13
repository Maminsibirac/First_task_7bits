package ru.omsu.formatter_code;

import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.another_char.AnotherCharFormat;
import ru.omsu.formatted.list_format.ListCharFormat;
import ru.omsu.reader.dom_parser.DomXmlParser;
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
    public static void formatter(IReaderStream readerStream, IWriterStream writerStream) {
        ListCharFormat listCharFormat = new ListCharFormat();
        int sizeListFormat = listCharFormat.getListFormat().size();
        AnotherCharFormat anotherCharFormat = AnotherCharFormat.onCreate();
        BaseProperties baseProperties = new BaseProperties(new DomXmlParser("src/main/resources/config"));
        BaseInput baseInput = new BaseInput();
        String text = "";

        while(readerStream.hasNextValue()) {
            baseInput.setInputSymbol(readerStream.readNextValue());

            for (int index = 0; index < sizeListFormat; ++index) {
                text += listCharFormat.getListFormat().get(index).formatter(baseInput, baseProperties);
            }

            if (text.isEmpty()) {
                text += anotherCharFormat.formatter(baseInput, baseProperties);
            }

            writerStream.writeValue(text);
            text = "";
        }
        writerStream.writeClose();
    }
}
