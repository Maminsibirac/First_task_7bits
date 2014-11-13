import org.junit.Test;
import ru.omsu.base.input.BaseInput;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.formatted.another_char.AnotherCharFormat;
import ru.omsu.formatted.list_format.ListCharFormat;
import ru.omsu.reader.dom_parser.DomXmlParser;

import static junit.framework.TestCase.assertEquals;

public class FormatterJavaCodeTest {
    @Test
    public void FormatterJavaCodeTest() {
        ListCharFormat listCharFormat = new ListCharFormat();
        int sizeList = listCharFormat.getListFormat().size();
        AnotherCharFormat anotherCharFormat = AnotherCharFormat.onCreate();
        BaseInput baseInput = new BaseInput();
        String test = "    string   =   fileName;   while   (   i    >       length    )   {      print  (  string    );    int j =    20;         }";
        String text = "";
        StringBuilder result = new StringBuilder();
        BaseProperties baseProperties = new BaseProperties(new DomXmlParser("config"));

        for (int i = 0; i < test.length(); ++i) {
            baseInput.setInputSymbol(test.charAt(i));
            for(int index = 0; index < sizeList; ++index) {
                text += listCharFormat.getListFormat().get(index).formatter(baseInput, baseProperties);
            }

            if(text.isEmpty()) {
                text = anotherCharFormat.formatter(baseInput, baseProperties);
            }

            result.append(text);
            text = "";
        }

        assertEquals("string = fileName;\nwhile (i > length ) {\n    print (string );\n    int j = 20;\n    \n}\n", result.toString());
    }
}
