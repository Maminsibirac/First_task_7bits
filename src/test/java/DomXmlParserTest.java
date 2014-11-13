import org.junit.Test;
import ru.omsu.reader.dom_parser.DomXmlParser;
import ru.omsu.reader.xml.IReaderXML;

import static org.junit.Assert.assertEquals;

public class DomXmlParserTest {
    @Test
    public void DomXmlParser() {
        IReaderXML domXmlParser = new DomXmlParser("config");
        assertEquals("4", domXmlParser.getChildValue("indent"));
    }
}
