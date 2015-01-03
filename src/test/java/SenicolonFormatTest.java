import org.junit.Test;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.semicolon.SemicolonFormat;

import static junit.framework.TestCase.assertEquals;

public class SenicolonFormatTest {
    @Test
    public void SenicolonFormatTest() {
        SemicolonFormat semicolonFormat = SemicolonFormat.onCreate();
        Memory memory = Memory.onCreate();
        String test = "while   (   i    >       length    );   string    =   pawd   ;      print  (  string   );    int j =    20;";
        String text = "";
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < test.length(); ++i) {
            memory.setInputSymbol(test.charAt(i));

            text = semicolonFormat.formatter(memory);

            if(text.isEmpty()) {
                text += memory.getInputSymbol();
            }

            result.append(text);
            text = "";
        }

        assertEquals("whilei>length;\nstring=pawd;\nprintstring;\nintj=20;\n", result.toString());
    }
}
