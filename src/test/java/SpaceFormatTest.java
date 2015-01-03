import org.junit.Test;
import ru.omsu.base.memory.Memory;
import ru.omsu.formatted.space.SpaceFormat;

import static junit.framework.TestCase.assertEquals;

public class SpaceFormatTest {
    @Test
    public void SpaceFormatTest() {
        SpaceFormat spaceFormat = SpaceFormat.onCreate();
        Memory memory = Memory.onCreate();
        String test = "while   (   i    >       length    )   {      print  (  string    )    int j =    20         }";
        String text = "";
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < test.length(); ++i) {
            memory.setInputSymbol(test.charAt(i));

            text = spaceFormat.formatter(memory);

            if(text.isEmpty()) {
                text += memory.getInputSymbol();
            }

            result.append(text);
            text = "";
        }

        assertEquals("while i > length  print string  int j = 20 ", result.toString());
    }
}
