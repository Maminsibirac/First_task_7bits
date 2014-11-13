import org.junit.Test;
import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.another_char.AnotherCharFormat;
import ru.omsu.formatted.space.SpaceFormat;
import ru.omsu.reader.dom_parser.DomXmlParser;

import static junit.framework.TestCase.assertEquals;

public class SpaceFormatTest {
    @Test
    public void SpaceFormatTest() {
        SpaceFormat spaceFormat = SpaceFormat.onCreate();
        AnotherCharFormat anotherCharFormat = AnotherCharFormat.onCreate();
        BaseInput baseInput = new BaseInput();
        String test = "while   (   i    >       length    )   {      print  (  string    )    int j =    20         }";
        String text = "";
        StringBuilder result = new StringBuilder();
        BaseProperties baseProperties = new BaseProperties(new DomXmlParser("config"));

        for (int i = 0; i < test.length(); ++i) {
            baseInput.setInputSymbol(test.charAt(i));

            text = spaceFormat.formatter(baseInput, baseProperties);

            if(text.isEmpty()) {
                text = anotherCharFormat.formatter(baseInput, baseProperties);
            }

            result.append(text);
            text = "";
        }

        assertEquals("while i > length  print string  int j = 20 ", result.toString());
    }
}
