package patterns.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import patterns.constant.FileType;
import patterns.parser.HTMLParser;
import patterns.parser.Parser;
import patterns.parser.XMLParser;

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
