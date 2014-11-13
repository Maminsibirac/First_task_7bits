import org.junit.Test;
import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.another_char.AnotherCharFormat;
import ru.omsu.formatted.indent.IndentFormat;
import ru.omsu.reader.dom_parser.DomXmlParser;

import static junit.framework.TestCase.assertEquals;

public class IndentFormatTest {
    @Test
    public void IndentFormatTest() {
        IndentFormat indentFormat = IndentFormat.onCreate();
        AnotherCharFormat anotherCharFormat = AnotherCharFormat.onCreate();
        BaseInput baseInput = new BaseInput();
        String test = "while   (   i    >       length    )   {      print  (  string    )    int j =    20         }";
        String text = "";
        StringBuilder result = new StringBuilder();
        BaseProperties baseProperties = new BaseProperties(new DomXmlParser("config"));

        for (int i = 0; i < test.length(); ++i) {
            baseInput.setInputSymbol(test.charAt(i));

            text = indentFormat.formatter(baseInput, baseProperties);

            if(text.isEmpty()) {
                text = anotherCharFormat.formatter(baseInput, baseProperties);
            }

            result.append(text);
            text = "";
        }

        assertEquals("whilei>length{\n    printstringintj=20\n}\n", result.toString());
    }
}
