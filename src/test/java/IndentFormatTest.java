import org.junit.Test;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.indent.IndentFormat;

import static junit.framework.TestCase.assertEquals;

public class IndentFormatTest {
    @Test
    public void IndentFormatTest() {
        IndentFormat indentFormat = IndentFormat.onCreate();
        Memory memory = Memory.onCreate();
        String test = "while   (   i    >       length    )   {      print  (  string    )    int j =    20         }";
        String text = "";
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < test.length(); ++i) {
            memory.setInputSymbol(test.charAt(i));

            text = indentFormat.formatter(memory);

            if(text.isEmpty()) {
                text += memory.getInputSymbol();
            }

            result.append(text);
            text = "";
        }

        assertEquals("whilei>length{\n    printstringintj=20\n}\n", result.toString());
    }
}
