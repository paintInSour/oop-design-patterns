package patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import patterns.constant.FileSource;
import patterns.constant.FileType;
import patterns.service.FileParserFactoryProviderService;
import patterns.file.File;
import patterns.file.HtmlFile;
import patterns.file.XMLFile;
import patterns.parser.Parser;

@SpringBootTest
class FactoryApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void assertCreatedHtmlParser() {
        String url = "https://www.baeldung.com/java-switch-pattern-matching";

        FileParserFactoryProviderService fileParserFactoryProviderService = new FileParserFactoryProviderService();
        var factory = fileParserFactoryProviderService.getFactory(FileSource.WEB);
        Parser parser = factory.getParser(FileType.HTML);
        File file = parser.parse(url);

        Assertions.assertTrue(file instanceof HtmlFile);
    }

    @Test
    void assertCreatedXMLParser() {
        String path = "/home/workspace/employee.xml";

        FileParserFactoryProviderService fileParserFactoryProviderService = new FileParserFactoryProviderService();
        var factory = fileParserFactoryProviderService.getFactory(FileSource.FILESYSTEM);
        Parser parser = factory.getParser(FileType.XML);
        File file = parser.parse(path);

        Assertions.assertTrue(file instanceof XMLFile);
    }
}
