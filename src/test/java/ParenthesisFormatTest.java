import org.junit.Test;
import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.another_char.AnotherCharFormat;
import ru.omsu.formatted.parentheses.left.ParenthesisLeftFormat;
import ru.omsu.formatted.parentheses.right.ParenthesisRightFormat;
import ru.omsu.reader.dom_parser.DomXmlParser;

import static junit.framework.TestCase.assertEquals;


public class ParenthesisFormatTest {
    @Test
    public void ParenthesisFormatTest() {
        ParenthesisLeftFormat parenthesisLeftFormat = ParenthesisLeftFormat.onCreate();
        ParenthesisRightFormat parenthesisRightFormat = ParenthesisRightFormat.onCreate();
        AnotherCharFormat anotherCharFormat = AnotherCharFormat.onCreate();
        BaseInput baseInput = new BaseInput();
        String test = "while   (   i    >       length    )   {      print  (  string    )    int j =    20;         }";
        String text = "";
        StringBuilder result = new StringBuilder();
        BaseProperties baseProperties = new BaseProperties(new DomXmlParser("config"));

        for (int i = 0; i < test.length(); ++i) {
            baseInput.setInputSymbol(test.charAt(i));
            text += parenthesisRightFormat.formatter(baseInput, baseProperties);
            text += parenthesisLeftFormat.formatter(baseInput, baseProperties);

            if(text.isEmpty()) {
                text = anotherCharFormat.formatter(baseInput, baseProperties);
            }

            result.append(text);
            text = "";
        }

        assertEquals("while(i>length)print(string)intj=20", result.toString());
    }
}
