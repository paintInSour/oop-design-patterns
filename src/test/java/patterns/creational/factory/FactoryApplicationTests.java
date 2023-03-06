package patterns.creational.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import patterns.creational.factory.constant.FileSource;
import patterns.creational.factory.constant.FileType;
import patterns.creational.factory.factory.FileParserFactoryProviderService;
import patterns.creational.factory.file.File;
import patterns.creational.factory.file.HtmlFile;
import patterns.creational.factory.file.XMLFile;
import patterns.creational.factory.parser.Parser;

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
