package patterns.creational.factory.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import patterns.creational.factory.constant.FileType;
import patterns.creational.factory.parser.HTMLParser;
import patterns.creational.factory.parser.Parser;
import patterns.creational.factory.parser.XMLParser;

@Slf4j
@Component
public class StaticFileParserFactory implements FileParserFactory<Parser> {

    @Override
    public Parser getParser(FileType fileType) {
        return switch (fileType) {
            case JSON -> new HTMLParser();
            case XML -> new XMLParser();
            default -> throw new RuntimeException("Not found implementation");
        };
    }
}
