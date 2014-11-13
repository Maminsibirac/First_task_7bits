import org.junit.Test;
import ru.omsu.base.properties.BaseProperties;
import ru.omsu.reader.dom_parser.DomXmlParser;
import static org.junit.Assert.assertEquals;

public class BasePropertiesTest {
    @Test
    public void BasePropertiesTest() {
        BaseProperties baseProperties = new BaseProperties(new DomXmlParser("1"));
        assertEquals(4, baseProperties.getLengthIndent());
        assertEquals("\r\n", baseProperties.getNewLine());
    }
}
